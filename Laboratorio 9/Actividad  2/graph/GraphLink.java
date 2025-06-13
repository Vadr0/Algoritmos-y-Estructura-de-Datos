package graph;

import java.util.ArrayList;
import linkedlist.ListLinked;
import queues.Queue;
import stacks.Stack;

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


    // insertEdgeWeight(v, z, w): inserta una arista del vértice v a z con peso w.
    // Cumple con lo que pide el Ejercicio 2.

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


 //Recorrido de profundidad
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





 // Ejercicio 1:
    // Recorrido de anchura
    public void bfs(E v) {
        int pos = listVertex.search(new Vertex<>(v));
        
        if (pos == -1) {
            System.out.println("Vertice no encontrado");
            return;
        }

        boolean[] visitado = new boolean[listVertex.lengthList()];
        Queue<Integer> cola = new Queue<>();

        visitado[pos] = true;

        cola.enqueue(pos);

        while (!cola.isEmpty()) {
            
            int actual = cola.dequeue();
            
            Vertex<E> vertice = listVertex.get(actual);
            
            System.out.println(vertice.getData() + " ");
            
            for (int i = 0; i < vertice.listAdj.lengthList(); i++) {
                
                Vertex<E> adyacente = vertice.listAdj.get(i).refDest;
                
                int posAdy = listVertex.search(adyacente);
                
                if (posAdy != -1 && !visitado[posAdy]) {
                    visitado[posAdy] = true;
                    cola.enqueue(posAdy);
                }
            }
        }
        System.out.println();
    }

    // Recorrido de anchura entre dos vertices
    public ArrayList<E> bfsPath(E v, E z) {

        //Lista que guardara el camino final
        ArrayList<E> path = new ArrayList<>();

        //Indices de vertices
        int start = listVertex.search(new Vertex<>(v));
        int end = listVertex.search(new Vertex<>(z));

        if (start == -1 || end == -1) return path;

        // Arreglo para chequear visitados
        boolean[] visitado = new boolean[listVertex.lengthList()];

        // Arreglo para ver los vertices anteriores y poder reconstruir caminos
        int[] prev = new int[listVertex.lengthList()];

        for (int i = 0; i < prev.length; i++){
            prev[i] = -1;
        } 

        // Cola para el bfs
        Queue<Integer> cola = new Queue<>();

        visitado[start] = true;

        cola.enqueue(start);

        while (!cola.isEmpty()) {

            int actual = cola.dequeue();

            if (actual == end) break;

            Vertex<E> vertice = listVertex.get(actual);

            for (int i = 0; i < vertice.listAdj.lengthList(); i++) {

                Vertex<E> adyacente = vertice.listAdj.get(i).refDest;

                int posAdy = listVertex.search(adyacente);

                if (posAdy != -1 && !visitado[posAdy]) {
                    
                    visitado[posAdy] = true;
                    
                    prev[posAdy] = actual;
                    
                    cola.enqueue(posAdy);
                }
            }
        }

        // Reconstruir el camino
        if (!visitado[end]){
             return path; // No hay camino
        }

        for (int at = end; at != -1; at = prev[at]) {
            path.add(0, listVertex.get(at).getData());
        }
        return path;
    }

 //Ejercicio 2
    // Determinar la ruta más corta entre el vértice v y z.
        // Basicamente es la implementacion de bfsPath
    public ArrayList<E> shortPath(E v, E z) {
        return bfsPath(v, z);
    }
    
    // Verificar si un grafo es conexo
    public boolean EsConexo() {
        if (listVertex.lengthList() == 0) return true; // empty = conexo por definición

        boolean[] visitado = new boolean[listVertex.lengthList()];
        // Hacemos DFS desde el primer vértice
        dfsUtil(0, visitado);

        // Si algún vértice no fue visitado, el grafo no es conexo
        for (boolean v : visitado) {
            if (!v) return false;
        }
        return true;
    }

    // Dijkstra: retorna un stack con la ruta más corta de un vértice v a otro w
    public Stack<E> Dijkstra(E v, E w) {
        int n = listVertex.lengthList();

        int start = listVertex.search(new Vertex<>(v));
        int end = listVertex.search(new Vertex<>(w));
        
        Stack<E> path = new Stack<>();
        if (start == -1 || end == -1) return path;

        int[] dist = new int[n];
        int[] prev = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }
        dist[start] = 0;

        for (int count = 0; count < n; count++) {
            // Buscar el vértice no visitado con menor distancia
            int u = -1;
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    u = i;
                }
            }
            if (u == -1) break; // No hay más alcanzables
            visited[u] = true;
            Vertex<E> vertice = listVertex.get(u);
            for (int i = 0; i < vertice.listAdj.lengthList(); i++) {
                Edge<E> edge = vertice.listAdj.get(i);
                Vertex<E> adj = edge.refDest;
                int vPos = listVertex.search(adj);
                int peso = edge.getWeight();
                if (peso < 0) peso = 1; // Si no tiene peso, considerar 1
                if (!visited[vPos] && dist[u] != Integer.MAX_VALUE && dist[u] + peso < dist[vPos]) {
                    dist[vPos] = dist[u] + peso;
                    prev[vPos] = u;
                }
            }
        }
        // Reconstruir el camino
        if (dist[end] == Integer.MAX_VALUE) return path; // No hay camino
        for (int at = end; at != -1; at = prev[at]) {
            path.push(listVertex.get(at).getData());
        }
        // El stack tiene el camino de destino a origen, lo invertimos
        Stack<E> result = new Stack<>();
        while (!path.isEmpty()) {
            result.push(path.pop());
        }
        return result;
    }

    public String toString() {
        return this.listVertex.toString();
    }

    // Devuelve la cantidad de vértices
    public int getVertexCount() {
        return listVertex.lengthList();
    }

    // Devuelve el vértice en la posición i
    public Vertex<E> getVertexByIndex(int i) {
        return listVertex.get(i);
    }
}
