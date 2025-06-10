package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        GrafoListaAristas<String, Integer> grafo = new GrafoListaAristas<>();

        grafo.insertarVertice("A");
        grafo.insertarVertice("B");
        grafo.insertarVertice("C");
        grafo.insertarVertice("D");

        grafo.insertarArista("A", "B", 4);
        grafo.insertarArista("A", "C", 3);
        grafo.insertarArista("B", "D", 2);

        System.out.println("Grafo representado por lista de estructura de aristas:");
        grafo.imprimirGrafo();

        System.out.println("Recorrido en profundidad desde A:");
        grafo.recorridoProfundidad("A");
    }
}
