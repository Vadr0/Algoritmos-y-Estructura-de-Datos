package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        GrafoListaArista<String, Integer> grafo = new GrafoListaArista<>();

        grafo.insertarVertice("A");
        grafo.insertarVertice("B");
        grafo.insertarVertice("C");
        grafo.insertarVertice("D");

        grafo.insertarArista("A", "B", 5);
        grafo.insertarArista("A", "C", 3);
        grafo.insertarArista("B", "D", 2);

        System.out.println("Contenido del grafo:");
        grafo.imprimirGrafo();

        System.out.println("Recorrido en anchura desde A:");
        grafo.recorridoAnchura("A");
    }
}
