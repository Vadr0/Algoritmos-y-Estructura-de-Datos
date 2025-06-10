package Ejercicio3;

public class Principal {
    public static void main(String[] args) {
        GraphListEdge<String, Integer> grafo = new GraphListEdge<>();

        grafo.insertarVertice("A");
        grafo.insertarVertice("B");
        grafo.insertarVertice("C");
        grafo.insertarVertice("D");

        grafo.insertarArista("A", "B");
        grafo.insertarArista("A", "C");
        grafo.insertarArista("B", "D");

        grafo.imprimirGrafo();

        System.out.println("¿Existe vértice C? " + grafo.buscarVertice("C"));
        System.out.println("¿Existe arista B-C? " + grafo.buscarArista("B", "C"));

        System.out.println("Recorrido BFS desde A:");
        grafo.bfs("A");
    }
}
