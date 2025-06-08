package test;
import graph.*;

public class MainGraph {
    public static void main(String[] args) {
        // Crear un grafo no dirigido y no ponderado
        GraphLink<String> grafo = new GraphLink<>(false, false);

        // Insertar vértices
        grafo.insertVertex("A");
        grafo.insertVertex("B");
        grafo.insertVertex("C");
        grafo.insertVertex("D");
        grafo.insertVertex("E");

        // Insertar aristas
        grafo.insertEdgeUndirected("A", "B");
        grafo.insertEdgeUndirected("A", "C");
        grafo.insertEdgeUndirected("B", "D");
        grafo.insertEdgeUndirected("C", "E");

        System.out.println("DFS desde A:");
        grafo.dfs("A");

        // Eliminar una arista y mostrar DFS
        grafo.removeEdgeUndirected("A", "B");
        System.out.println("DFS desde A (sin arista A-B):");
        grafo.dfs("A");

        // Eliminar un vértice y mostrar DFS
        grafo.removeVertex("C");
        System.out.println("DFS desde A (sin vértice C):");
        grafo.dfs("A");
    }
}
