package graph;

import linkedlist.ListLinked;

public class GraphLink<E> {

    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data) {
        if (data == null) {
            throw new IllegalArgumentException("El dato no debe ser null");
        }
        if (listVertex.search(new Vertex<>(data)) != -1) {
            return;
        }
        listVertex.insertLast(new Vertex<>(data));
    }

    public void insertEdge(E verOrigen, E verDestino) {
        if (verOrigen == null || verDestino == null) {
            throw new IllegalArgumentException("Los vertices no pueden ser null");
        }
        int posOrigen = listVertex.search(new Vertex<>(verOrigen));
        int posDestino = listVertex.search(new Vertex<>(verDestino));

        if (posOrigen == -1 || posDestino == -1) {
            return; // Ya que no existe uno de los vertices
        }

        Vertex<E> origen = listVertex.get(posOrigen);
        Vertex<E> destino = listVertex.get(posDestino);

        if (origen.listAdj.search(new Edge<>(destino)) != -1) {
            return; // Ya que existe esta arista
        }

        origen.listAdj.insertLast(new Edge<>(destino));
    }

    public void insertEdge(E verOrigen, E verDestino, int peso) {
        if (verOrigen == null || verDestino == null) {
            throw new IllegalArgumentException("Los vertices no pueden ser null");
        }

        int posOrigen = listVertex.search(new Vertex<>(verOrigen));
        int posDestino = listVertex.search(new Vertex<>(verDestino));

        if (posOrigen == -1 || posDestino == -1) {
            return;
        }

        Vertex<E> origen = listVertex.get(posOrigen);
        Vertex<E> destino = listVertex.get(posDestino);

        if (origen.listAdj.search(new Edge<>(destino, peso)) != -1) {
            return;
        }

        origen.listAdj.insertLast(new Edge<>(destino, peso));
    }

    // Para grafos no dirigidos, la unica diferencia es que se inserta en ambas
    // direcciones
    public void insertEdgeUndirected(E verOrigen, E verDestino) {
        insertEdge(verOrigen, verDestino);
        insertEdge(verDestino, verOrigen);
    }

    // Para buscar vertices, se busca en la lista de vertices
    // Si no se encuentra retorna false
    public boolean searchVertex(E vertex) {
        return listVertex.search(new Vertex<>(vertex)) != -1;
    }

    public boolean searchEdge(E v, E z) {
        int posOrigen = listVertex.search(new Vertex<>(v));
        int posDestino = listVertex.search(new Vertex<>(z));
        if (posOrigen == -1 || posDestino == -1) {
            return false;
        }
        Vertex<E> origen = listVertex.get(posOrigen);
        Vertex<E> destino = listVertex.get(posDestino);
        return origen.listAdj.search(new Edge<>(destino)) != -1;
    }

    public String toString() {
        return this.listVertex.toString();
    }
}
