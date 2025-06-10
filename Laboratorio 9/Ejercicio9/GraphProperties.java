package Ejercicio9;

import graph.GraphLink;
import graph.Vertex;
import java.util.*;

public class GraphProperties {
    // a) Isomorfismo básico: mismo número de vértices, aristas y secuencia de grados
    public static <E> boolean isIsomorphic(GraphLink<E> g1, GraphLink<E> g2) {
        if (g1.getVertexCount() != g2.getVertexCount()) return false;
        int m1 = countEdges(g1);
        int m2 = countEdges(g2);
        if (m1 != m2) return false;
        List<Integer> grados1 = getDegreeSequence(g1);
        List<Integer> grados2 = getDegreeSequence(g2);
        Collections.sort(grados1);
        Collections.sort(grados2);
        return grados1.equals(grados2);
    }

    // b) Plano: para grafos simples, usar fórmula de Euler (solo para grafos conexos y sin lazos/multiaristas)
    public static <E> boolean isPlanar(GraphLink<E> g) {
        int n = g.getVertexCount();
        int m = countEdges(g);
        if (n <= 4) return true; // Todo grafo con <=4 vértices es plano
        // Fórmula de Euler para grafos simples conexos: m <= 3n - 6
        if (!isConnected(g)) return false;
        return m <= 3 * n - 6;
    }

    // c) Conexo: usando DFS
    public static <E> boolean isConnected(GraphLink<E> g) {
        if (g.getVertexCount() == 0) return true;
        boolean[] visitado = new boolean[g.getVertexCount()];
        dfs(g, 0, visitado);
        for (boolean v : visitado) if (!v) return false;
        return true;
    }
    private static <E> void dfs(GraphLink<E> g, int pos, boolean[] visitado) {
        visitado[pos] = true;
        Vertex<E> v = g.getVertexByIndex(pos);
        for (int i = 0; i < v.getAdjListSize(); i++) {
            Vertex<E> ady = v.getListAdj().get(i).refDest;
            int posAdy = -1;
            for (int j = 0; j < g.getVertexCount(); j++) {
                if (g.getVertexByIndex(j).equals(ady)) { posAdy = j; break; }
            }
            if (posAdy != -1 && !visitado[posAdy]) dfs(g, posAdy, visitado);
        }
    }

    // d) Auto-complementario: el complemento es isomorfo al original
    public static <E> boolean isSelfComplementary(GraphLink<E> g) {
        GraphLink<E> comp = getComplement(g);
        return isIsomorphic(g, comp);
    }
    // Complemento de un grafo
    public static <E> GraphLink<E> getComplement(GraphLink<E> g) {
        GraphLink<E> comp = new GraphLink<>(true, false); // dirigido, no ponderado
        int n = g.getVertexCount();
        for (int i = 0; i < n; i++) comp.insertVertex(g.getVertexByIndex(i).getData());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    Vertex<E> v1 = g.getVertexByIndex(i);
                    Vertex<E> v2 = g.getVertexByIndex(j);
                    boolean existe = false;
                    for (int k = 0; k < v1.getAdjListSize(); k++) {
                        if (v1.getListAdj().get(k).refDest.equals(v2)) {
                            existe = true; break;
                        }
                    }
                    if (!existe) comp.insertEdge(v1.getData(), v2.getData());
                }
            }
        }
        return comp;
    }

    // Utilidades
    private static <E> int countEdges(GraphLink<E> g) {
        int m = 0;
        for (int i = 0; i < g.getVertexCount(); i++) {
            m += g.getVertexByIndex(i).getAdjListSize();
        }
        return m;
    }
    private static <E> List<Integer> getDegreeSequence(GraphLink<E> g) {
        List<Integer> grados = new ArrayList<>();
        for (int i = 0; i < g.getVertexCount(); i++) {
            grados.add(g.getVertexByIndex(i).getAdjListSize());
        }
        return grados;
    }
}
