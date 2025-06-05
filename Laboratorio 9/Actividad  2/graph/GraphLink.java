package graph;

import linkedlist.ListLinked;

public class GraphLink<E> {

    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data) {
        if (listVertex.search(new Vertex<>(data)) != -1) {
            return;
        }
        listVertex.insertLast(new Vertex<>(data));
    }
    
    public void insertEdge(E verOrigen, E verDestino) {

    }

    public String toString() {
        return this.listVertex.toString();
    }
}
