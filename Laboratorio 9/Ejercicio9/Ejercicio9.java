package Ejercicio9;

import graph.GraphLink;

public class Ejercicio9 {
    public static void main(String[] args) {
        // Ejemplo de uso con GraphLink
        GraphLink<String> g1 = new GraphLink<>(true, false); // dirigido, no ponderado
        g1.insertVertex("A");
        g1.insertVertex("B");
        g1.insertVertex("C");
        g1.insertEdge("A", "B");
        g1.insertEdge("B", "C");
        g1.insertEdge("C", "A");

        GraphLink<String> g2 = new GraphLink<>(true, false);
        g2.insertVertex("X");
        g2.insertVertex("Y");
        g2.insertVertex("Z");
        g2.insertEdge("X", "Y");
        g2.insertEdge("Y", "Z");
        g2.insertEdge("Z", "X");

        System.out.println("¿g1 y g2 son isomorfos? " + GraphProperties.isIsomorphic(g1, g2));
        System.out.println("¿g1 es plano? " + GraphProperties.isPlanar(g1));
        System.out.println("¿g1 es conexo? " + GraphProperties.isConnected(g1));
        System.out.println("¿g1 es auto-complementario? " + GraphProperties.isSelfComplementary(g1));
    }
}
