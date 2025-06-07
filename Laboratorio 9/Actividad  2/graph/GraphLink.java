package graph;

import linkedlist.ListLinked;

public class GraphLink<E> {

    protected ListLinked<Vertex<E>> listVertex;
    private boolean esDirigido;
    private boolean esPonderado;

    public GraphLink(boolean esDirigido, boolean esPonderado) {
        listVertex = new ListLinked<Vertex<E>>();
        this.esDirigido = esDirigido;
        this.esPonderado = esPonderado;
    }


 // Metodos para insertar 

    // Insertar Vertices:
    public void insertVertex(E data) {
        if (data == null) {
            throw new IllegalArgumentException("El dato no debe ser null");
        }
        if (listVertex.search(new Vertex<>(data)) != -1) {
            return;
        }
        listVertex.insertLast(new Vertex<>(data));
    }

    //Insertar Aristas en Grafos Dirigidos:
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

    //Insertar Aristas Ponderadas en Grafos No Dirigidos:
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

    // Insertar Aristas en Grafos No Dirigidos:
    public void insertEdgeUndirected(E verOrigen, E verDestino) {
        insertEdge(verOrigen, verDestino);
        insertEdge(verDestino, verOrigen);
    }

    // Insertar Aristas en Grafos No Dirigidos Ponderados:
    public void insertEdgeUndirected(E verOrigen, E verDestino, int peso) {
        insertEdge(verOrigen, verDestino, peso);
        insertEdge(verDestino, verOrigen, peso);
    }





 //Metodos para busqueda:

    //Buscar vertices:
    public boolean searchVertex(E vertex) {
        return listVertex.search(new Vertex<>(vertex)) != -1;
    }

    //Buscar Aristas:
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
