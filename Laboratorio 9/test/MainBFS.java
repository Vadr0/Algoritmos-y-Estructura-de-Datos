package test;

import java.util.ArrayList;
import graph.*;

public class MainBFS {
    public static void main(String[] args) {
        GraphLink<String> g = new GraphLink<>(false, false);

        // Insertar vértices
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");
        g.insertVertex("E");

        // Insertar aristas (no dirigido)
        g.insertEdgeUndirected("A", "B");
        g.insertEdgeUndirected("A", "C");
        g.insertEdgeUndirected("B", "D");
        g.insertEdgeUndirected("C", "E");
        g.insertEdgeUndirected("D", "E");

        // Probar bfsPath
        ArrayList<String> camino = g.bfsPath("A", "E");
        System.out.println("Camino de A a E: " + camino);

        // Probar cuando no hay camino
        g.insertVertex("F");
        ArrayList<String> sinCamino = g.bfsPath("A", "F");
        System.out.println("Camino de A a F: " + sinCamino);
    }
}
