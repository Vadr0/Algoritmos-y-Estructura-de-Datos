package Ejercicio7;

public class Main {
    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido();

        grafo.insertarVertice("A");
        grafo.insertarVertice("B");
        grafo.insertarVertice("C");
        grafo.insertarVertice("D");

        grafo.insertarArista("A", "B", 1);
        grafo.insertarArista("B", "C", 1);
        grafo.insertarArista("C", "D", 1);

        System.out.println("¿Es camino dirigido?: " + AnalizadorGrafosDirigidos.esCamino(grafo));
        System.out.println("¿Es ciclo dirigido?: " + AnalizadorGrafosDirigidos.esCiclo(grafo));
        System.out.println("¿Es grafo completo?: " + AnalizadorGrafosDirigidos.esCompleto(grafo));
        System.out.println("¿Es rueda dirigida?: " + AnalizadorGrafosDirigidos.esRueda(grafo));
    }
}
