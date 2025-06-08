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




 // Metodos para eliminar:

    // Eliminar un vertice y sus aristas asociadas:
    public void removeVertex(E v) {
        int pos = listVertex.search(new Vertex<>(v));
        if (pos == -1) return; // No existe el vertice

        Vertex<E> vertexToRemove = listVertex.get(pos);

        //Eliminar todas las aristas adyacentes que se originan en el vertice
        vertexToRemove.listAdj.destroyList();

        //Eliminar todas las aristas que van hacia el vertice
        for (int i = 0; i < listVertex.lengthList(); i++){
            Vertex<E> current = listVertex.get(i);
                // Eliminar aristas que apunten a vertex to Remove
            for(int j = 0; j < current.listAdj.lengthList();) {
                if (current.listAdj.get(j).refDest.equals(vertexToRemove)){
                    current.listAdj.removeNode(current.listAdj.get(j));
                } else {
                    j++;
                }
            }
        }

        //Eliminar el vertice de la lista de vertices
        listVertex.removeNode(vertexToRemove);
    }

    // Eliminar una arista en grafos dirigidos
    public void removeEdge(E v, E z) {
        int posOrigen = listVertex.search(new Vertex<>(v));
        int posDestino = listVertex.search(new Vertex<>(z));

        if (posOrigen == -1 || posDestino == -1){
            return;
        }

        Vertex<E> origen = listVertex.get(posOrigen);
        Vertex<E> destino = listVertex.get(posDestino);

        for (int i = 0; i > origen.listAdj.lengthList(); i++){
            if (origen.listAdj.get(i).refDest.equals(destino)) {
                origen.listAdj.removeNode(origen.listAdj.get(i));
                break;
            }
        }
    }

    // Eliminar una arista en grafos no dirigidos
    public void removeEdgeUndirected(E v, E z){
        removeEdge(v, z);
        removeEdge(z, v);
    }


 //Recorridos del grafo
    public void dfs(E v) {
        int pos = listVertex.search(new Vertex<>(v));
        if (pos == -1){
            System.out.println("Vertice no encontrado");
            return;
        }
        boolean[] visitado = new boolean[listVertex.lengthList()];
        dfsUtil(pos,visitado);
        System.out.println();
    }

    private void dfsUtil(int pos, boolean[] visitado){
        visitado[pos] = true;
        Vertex<E> vertice = listVertex.get(pos);
        System.out.println(vertice.getData() + " ");
        for (int i = 0; i < vertice.listAdj.lengthList(); i++){
            Vertex<E> adyacente = vertice.listAdj.get(i).refDest;
            int posAdy = listVertex.search(adyacente);
            if (posAdy != -1 && !visitado[posAdy]) {
                dfsUtil(posAdy, visitado);
            }
        }
    }






    public String toString() {
        return this.listVertex.toString();
    }
}
