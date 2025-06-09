package Ejercicio5;

import graph.GraphLink;
import graph.Vertex;

public class GraphAnalyzer {
    // a) Grado de un nodo (cantidad de aristas conectadas)
    public static <E> int gradoNodo(GraphLink<E> grafo, E nodo) {
        int n = grafo.getVertexCount();
        for (int i = 0; i < n; i++) {
            Vertex<E> v = grafo.getVertexByIndex(i);
            if (v.getData().equals(nodo)) {
                return v.getAdjListSize();
            }
        }
        return -1;
    }

    // b) Es camino (Px): todos los nodos de grado 2 excepto los extremos (grado 1)
    public static <E> boolean esCamino(GraphLink<E> grafo) {
        int n = grafo.getVertexCount();
        int extremos = 0;
        for (int i = 0; i < n; i++) {
            Vertex<E> v = grafo.getVertexByIndex(i);
            int grado = v.getAdjListSize();
            if (grado == 1) extremos++;
            else if (grado != 2) return false;
        }
        return extremos == 2;
    }

    // c) Es ciclo (Cx): todos los nodos de grado 2
    public static <E> boolean esCiclo(GraphLink<E> grafo) {
        int n = grafo.getVertexCount();
        for (int i = 0; i < n; i++) {
            Vertex<E> v = grafo.getVertexByIndex(i);
            if (v.getAdjListSize() != 2) return false;
        }
        return true;
    }

    // d) Es rueda (Wx): un nodo de grado n-1, los demás de grado 3
    public static <E> boolean esRueda(GraphLink<E> grafo) {
        int n = grafo.getVertexCount();
        int centro = 0, periferia = 0;
        for (int i = 0; i < n; i++) {
            Vertex<E> v = grafo.getVertexByIndex(i);
            int grado = v.getAdjListSize();
            if (grado == n-1) centro++;
            else if (grado == 3) periferia++;
        }
        return centro == 1 && periferia == n-1;
    }

    // e) Es completo (Kx): todos los nodos de grado n-1
    public static <E> boolean esCompleto(GraphLink<E> grafo) {
        int n = grafo.getVertexCount();
        for (int i = 0; i < n; i++) {
            Vertex<E> v = grafo.getVertexByIndex(i);
            if (v.getAdjListSize() != n-1) return false;
        }
        return true;
    }
}
