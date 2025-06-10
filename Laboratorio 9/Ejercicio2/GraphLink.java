package Ejercicio2;

public class GraphLink {
    private Vertice primero;

    public GraphLink() {
        this.primero = null;
    }

    public void insertarVertice(String dato) {
        if (!buscarVertice(dato)) {
            Vertice nuevo = new Vertice(dato);
            nuevo.siguiente = primero;
            primero = nuevo;
        }
    }

    public boolean buscarVertice(String dato) {
        Vertice actual = primero;
        while (actual != null) {
            if (actual.dato.equals(dato)) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    private Vertice obtenerVertice(String dato) {
        Vertice actual = primero;
        while (actual != null) {
            if (actual.dato.equals(dato)) return actual;
            actual = actual.siguiente;
        }
        return null;
    }

    // a) insertEdgeWeight
    public void insertarAristaPeso(String dato1, String dato2, int peso) {
        Vertice v1 = obtenerVertice(dato1);
        Vertice v2 = obtenerVertice(dato2);
        if (v1 != null && v2 != null && !existeArista(v1, v2)) {
            Arista a1 = new Arista(v2, peso);
            a1.siguiente = v1.adyacente;
            v1.adyacente = a1;

            Arista a2 = new Arista(v1, peso);
            a2.siguiente = v2.adyacente;
            v2.adyacente = a2;
        }
    }

    private boolean existeArista(Vertice v1, Vertice v2) {
        Arista actual = v1.adyacente;
        while (actual != null) {
            if (actual.destino == v2) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    // b) shortPath usando BFS y acumulación de distancia mínima (sin prioridad)
    public Lista caminoMasCorto(String origen, String destino) {
        limpiarVisitas();
        Lista recorrido = new Lista();
        Lista cola = new Lista();
        int[] distancias = new int[100];
        String[] previos = new String[100];
        String[] nombres = new String[100];
        int count = 0;

        Vertice actual = primero;
        while (actual != null) {
            nombres[count] = actual.dato;
            distancias[count] = (actual.dato.equals(origen)) ? 0 : 9999;
            previos[count] = null;
            count++;
            actual = actual.siguiente;
        }

        cola.agregar(origen);

        while (cola.tamaño() > 0) {
            String actualDato = cola.obtener(0);
            cola.limpiar();
            Vertice vActual = obtenerVertice(actualDato);
            int iActual = indiceDe(nombres, actualDato, count);

            Arista arista = vActual.adyacente;
            while (arista != null) {
                String vecino = arista.destino.dato;
                int iVecino = indiceDe(nombres, vecino, count);
                int nuevaDist = distancias[iActual] + arista.peso;
                if (nuevaDist < distancias[iVecino]) {
                    distancias[iVecino] = nuevaDist;
                    previos[iVecino] = actualDato;
                    cola.agregar(vecino);
                }
                arista = arista.siguiente;
            }
        }

        int indexDestino = indiceDe(nombres, destino, count);
        if (distancias[indexDestino] == 9999) return recorrido;

        // reconstruir camino
        String actualCamino = destino;
        while (actualCamino != null) {
            recorrido.agregar(actualCamino);
            actualCamino = previos[indiceDe(nombres, actualCamino, count)];
        }

        // invertir recorrido
        Lista caminoFinal = new Lista();
        for (int i = recorrido.tamaño() - 1; i >= 0; i--) {
            caminoFinal.agregar(recorrido.obtener(i));
        }

        return caminoFinal;
    }

    private int indiceDe(String[] arreglo, String dato, int total) {
        for (int i = 0; i < total; i++) {
            if (arreglo[i].equals(dato)) return i;
        }
        return -1;
    }

    // c) isConexo (DFS)
    public boolean esConexo() {
        limpiarVisitas();
        Lista visitados = new Lista();
        dfsInterno(primero, visitados);
        int total = contarVertices();
        return visitados.tamaño() == total;
    }

    private void dfsInterno(Vertice v, Lista visitados) {
        if (v == null || visitados.contiene(v.dato)) return;
        visitados.agregar(v.dato);
        Arista a = v.adyacente;
        while (a != null) {
            dfsInterno(a.destino, visitados);
            a = a.siguiente;
        }
    }

    private int contarVertices() {
        int c = 0;
        Vertice aux = primero;
        while (aux != null) {
            c++;
            aux = aux.siguiente;
        }
        return c;
    }

    private void limpiarVisitas() {
        Vertice actual = primero;
        while (actual != null) {
            actual.visitado = false;
            actual = actual.siguiente;
        }
    }

    // d) Dijkstra clásico usando arreglos (retorna una Pila)
    public Pila dijkstra(String origen, String destino) {
        limpiarVisitas();
        Pila resultado = new Pila();
        String[] vertices = new String[100];
        int[] distancias = new int[100];
        String[] previos = new String[100];
        boolean[] visitados = new boolean[100];
        int total = 0;

        Vertice actual = primero;
        while (actual != null) {
            vertices[total] = actual.dato;
            distancias[total] = (actual.dato.equals(origen)) ? 0 : 9999;
            previos[total] = null;
            visitados[total] = false;
            total++;
            actual = actual.siguiente;
        }

        for (int i = 0; i < total; i++) {
            int u = minimoNoVisitado(distancias, visitados, total);
            visitados[u] = true;

            Vertice v = obtenerVertice(vertices[u]);
            Arista a = v.adyacente;
            while (a != null) {
                int j = indiceDe(vertices, a.destino.dato, total);
                if (!visitados[j]) {
                    int nuevaDist = distancias[u] + a.peso;
                    if (nuevaDist < distancias[j]) {
                        distancias[j] = nuevaDist;
                        previos[j] = vertices[u];
                    }
                }
                a = a.siguiente;
            }
        }

        String actualNodo = destino;
        while (actualNodo != null) {
            resultado.apilar(actualNodo);
            actualNodo = previos[indiceDe(vertices, actualNodo, total)];
        }

        return resultado;
    }

    private int minimoNoVisitado(int[] distancias, boolean[] visitados, int total) {
        int min = 99999;
        int indice = -1;
        for (int i = 0; i < total; i++) {
            if (!visitados[i] && distancias[i] < min) {
                min = distancias[i];
                indice = i;
            }
        }
        return indice;
    }

    public void imprimirGrafo() {
        Vertice v = primero;
        while (v != null) {
            System.out.print(v.dato + " -> ");
            Arista a = v.adyacente;
            while (a != null) {
                System.out.print("(" + a.destino.dato + ", peso: " + a.peso + ") ");
                a = a.siguiente;
            }
            System.out.println();
            v = v.siguiente;
        }
    }
}
