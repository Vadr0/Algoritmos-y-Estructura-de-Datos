package graph;

import java.util.ArrayList;
//Actividad 3
public class zGraphListEdge<V,E> {
    ArrayList<zVertexObj<V,E>> secVertex;
    ArrayList<zEdgeObj<V,E>> secEdge;

    public zGraphListEdge(){
        this.secVertex = new ArrayList<zVertexObj<V,E>>();
        this.secEdge = new ArrayList<zEdgeObj<V,E>>();
    }

    // Inserta el vértice 'v' en caso no exista
    public void insertVertex(V v) {
        if (v == null) {
            throw new IllegalArgumentException("El vértice no debe ser null");
        }
        // Verificar si ya existe
        for (zVertexObj<V,E> vert : secVertex) {
            if (vert.getInfo().equals(v)) {
                return;
            }
        }
        // El position será el tamaño actual de la lista
        secVertex.add(new zVertexObj<>(v, secVertex.size()));
    }

    // Inserta la arista entre los vértices 'v' y 'z' si no existe
    public void insertEdge(V v, V z) {
        // Buscar los vértices
        zVertexObj<V,E> vert1 = null, vert2 = null;
        for (zVertexObj<V,E> vert : secVertex) {
            if (vert.getInfo().equals(v)) vert1 = vert;
            if (vert.getInfo().equals(z)) vert2 = vert;
        }
        if (vert1 == null || vert2 == null) return; // Algún vértice no existe
        // Verificar si ya existe la arista (no dirigido: buscar ambos sentidos)
        for (zEdgeObj<V,E> edge : secEdge) {
            if ((edge.endVertex1 == vert1 && edge.endVertex2 == vert2) ||
                (edge.endVertex1 == vert2 && edge.endVertex2 == vert1)) {
                return; // Ya existe
            }
        }
        // Insertar la arista, info=null, posición = tamaño actual
        secEdge.add(new zEdgeObj<>(vert1, vert2, null, secEdge.size()));
    }

    // Busca el vértice 'v' y retorna verdadero si existe
    public boolean searchVertex(V v) {
        for (zVertexObj<V,E> vert : secVertex) {
            if (vert.getInfo().equals(v)) {
                return true;
            }
        }
        return false;
    }

    // Busca la arista entre los vértices 'v' y 'z'. Retorna verdadero si existe
    public boolean searchEdge(V v, V z) {
        zVertexObj<V,E> vert1 = null, vert2 = null;
        for (zVertexObj<V,E> vert : secVertex) {
            if (vert.getInfo().equals(v)) vert1 = vert;
            if (vert.getInfo().equals(z)) vert2 = vert;
        }
        if (vert1 == null || vert2 == null) return false;
        for (zEdgeObj<V,E> edge : secEdge) {
            if ((edge.endVertex1 == vert1 && edge.endVertex2 == vert2) ||
                (edge.endVertex1 == vert2 && edge.endVertex2 == vert1)) {
                return true;
            }
        }
        return false;
    }

    // Recorrido en anchura (BFS) desde el vértice 'v'
    public void bfs(V v) {
        zVertexObj<V,E> start = null;
        for (zVertexObj<V,E> vert : secVertex) {
            if (vert.getInfo().equals(v)) {
                start = vert;
                break;
            }
        }
        if (start == null) {
            System.out.println("Vértice no encontrado");
            return;
        }
        boolean[] visitado = new boolean[secVertex.size()];
        ArrayList<zVertexObj<V,E>> cola = new ArrayList<>();
        cola.add(start);
        visitado[start.position] = true;
        while (!cola.isEmpty()) {
            zVertexObj<V,E> actual = cola.remove(0);
            System.out.print(actual.getInfo() + " ");
            // Buscar adyacentes
            for (zEdgeObj<V,E> edge : secEdge) {
                zVertexObj<V,E> ady = null;
                if (edge.endVertex1 == actual) ady = edge.endVertex2;
                else if (edge.endVertex2 == actual) ady = edge.endVertex1;
                if (ady != null && !visitado[ady.position]) {
                    cola.add(ady);
                    visitado[ady.position] = true;
                }
            }
        }
        System.out.println();
    }
}
