package test;

import graph.zGraphListEdge;

public class MainGraphListEdge {
    public static void main(String[] args) {
        zGraphListEdge<String, Object> grafo = new zGraphListEdge<>();

        // Insertar vértices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");

        // Insertar aristas
        grafo.insertEdge("A", "B");
        grafo.insertEdge("A", "C");
        grafo.insertEdge("B", "D");
        grafo.insertEdge("C", "D");
        grafo.insertEdge("D", "E");

        // Prueba de búsqueda de vértices
        System.out.println("¿Existe el vértice A? " + grafo.searchVertex("A")); // true
        System.out.println("¿Existe el vértice F? " + grafo.searchVertex("F")); // false

        // Prueba de búsqueda de aristas
        System.out.println("¿Existe la arista A-B? " + grafo.searchEdge("A", "B")); // true
        System.out.println("¿Existe la arista B-E? " + grafo.searchEdge("B", "E")); // false

        // Prueba de BFS
        System.out.print("Recorrido BFS desde A: ");
        grafo.bfs("A");
        System.out.print("Recorrido BFS desde D: ");
        grafo.bfs("D");
    }
}
