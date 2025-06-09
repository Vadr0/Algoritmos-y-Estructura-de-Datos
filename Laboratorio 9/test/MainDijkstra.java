package test;

import stacks.Stack;
import graph.*;

public class MainDijkstra {
    public static void main(String[] args) {
        // Crear un grafo dirigido y ponderado
        GraphLink<String> grafo = new GraphLink<>(true, true);

        // Agregar vértices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");

        // Agregar aristas ponderadas
        grafo.insertEdge("A", "B", 2);
        grafo.insertEdge("A", "C", 5);
        grafo.insertEdge("B", "C", 1);
        grafo.insertEdge("B", "D", 2);
        grafo.insertEdge("C", "D", 3);
        grafo.insertEdge("D", "E", 1);
        grafo.insertEdge("C", "E", 5);

        // Probar Dijkstra de A a E
        Stack<String> camino = grafo.Dijkstra("A", "E");

        // Pasar el stack a una lista para imprimir en orden de origen a destino
        java.util.ArrayList<String> ruta = new java.util.ArrayList<>();
        while (!camino.isEmpty()) {
            ruta.add(camino.pop());
        }
        System.out.print("Ruta más corta de A a E: ");
        for (int i = ruta.size() - 1; i >= 0; i--) {
            System.out.print(ruta.get(i));
            if (i > 0) System.out.print(" -> ");
        }
        System.out.println();
    }
}