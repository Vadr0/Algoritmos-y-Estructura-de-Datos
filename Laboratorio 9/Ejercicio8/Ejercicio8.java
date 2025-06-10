package Ejercicio8;

import graph.GraphLink;
import graph.Vertex;

public class Ejercicio8 {
    public static void main(String[] args) {
        // Crear grafo no dirigido
        GraphLink<String> grafo = new GraphLink<>(false, false);
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");

        grafo.insertEdgeUndirected("A", "B");
        grafo.insertEdgeUndirected("A", "C");
        grafo.insertEdgeUndirected("B", "D");
        grafo.insertEdgeUndirected("C", "E");
        grafo.insertEdgeUndirected("D", "E");

        // a) Formal
        System.out.println("a) Formal:");
        System.out.print("Vértices: ");
        for (int i = 0; i < grafo.getVertexCount(); i++) {
            System.out.print(grafo.getVertexByIndex(i).getData() + " ");
        }
        System.out.println("\nAristas:");
        for (int i = 0; i < grafo.getVertexCount(); i++) {
            Vertex<String> v = grafo.getVertexByIndex(i);
            for (int j = 0; j < v.getAdjListSize(); j++) {
                String destino = v.getListAdj().get(j).refDest.getData();
                if (v.getData().compareTo(destino) < 0) {
                    System.out.println("(" + v.getData() + ", " + destino + ")");
                }
            }
        }

        // b) Lista de adyacencias
        System.out.println("\nb) Lista de adyacencias:");
        for (int i = 0; i < grafo.getVertexCount(); i++) {
            Vertex<String> v = grafo.getVertexByIndex(i);
            System.out.print(v.getData() + ": ");
            for (int j = 0; j < v.getAdjListSize(); j++) {
                System.out.print(v.getListAdj().get(j).refDest.getData() + " ");
            }
            System.out.println();
        }

        // c) Matriz de adyacencia
        System.out.println("\nc) Matriz de adyacencia:");
        int n = grafo.getVertexCount();
        String[] nombres = new String[n];
        for (int i = 0; i < n; i++) nombres[i] = grafo.getVertexByIndex(i).getData();
        System.out.print("    ");
        for (int i = 0; i < n; i++) System.out.print(nombres[i] + " ");
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(nombres[i] + " | ");
            for (int j = 0; j < n; j++) {
                boolean conectado = false;
                Vertex<String> v = grafo.getVertexByIndex(i);
                for (int k = 0; k < v.getAdjListSize(); k++) {
                    if (v.getListAdj().get(k).refDest.getData().equals(nombres[j])) {
                        conectado = true;
                        break;
                    }
                }
                System.out.print((conectado ? "1" : "0") + " ");
            }
            System.out.println();
        }
    }
}
