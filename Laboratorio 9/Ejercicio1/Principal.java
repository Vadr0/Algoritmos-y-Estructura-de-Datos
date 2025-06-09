package Ejercicio1;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        GrafoEnlazado grafo = new GrafoEnlazado();

        grafo.insertarArista("A", "B");
        grafo.insertarArista("A", "C");
        grafo.insertarArista("B", "D");
        grafo.insertarArista("C", "D");
        grafo.insertarArista("D", "E");

        grafo.recorridoAnchura("A");

        ArrayList<String> camino = grafo.caminoAnchura("A", "E");
        System.out.println("Camino más corto de A a E: " + camino);
    }
}
