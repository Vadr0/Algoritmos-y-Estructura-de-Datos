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
}
