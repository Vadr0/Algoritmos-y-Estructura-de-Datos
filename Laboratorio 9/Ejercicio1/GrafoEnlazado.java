package Ejercicio1;

import java.util.*;

public class GrafoEnlazado {
    private ListaEnlazada<Vertice> vertices;
    private Map<String, ListaEnlazada<Arista>> listaAdyacencia;

    public GrafoEnlazado() {
        vertices = new ListaEnlazada<>();
        listaAdyacencia = new HashMap<>();
    }

    public void insertarVertice(String nombre) {
        if (!buscarVertice(nombre)) {
            Vertice v = new Vertice(nombre);
            vertices.insertarAlFinal(v);
            listaAdyacencia.put(nombre, new ListaEnlazada<>());
        }
    }

    public void insertarArista(String origen, String destino) {
        if (!buscarVertice(origen)) insertarVertice(origen);
        if (!buscarVertice(destino)) insertarVertice(destino);

        Vertice vDestino = new Vertice(destino);
        Vertice vOrigen = new Vertice(origen);

        listaAdyacencia.get(origen).insertarAlFinal(new Arista(vDestino));
        listaAdyacencia.get(destino).insertarAlFinal(new Arista(vOrigen)); // no dirigido
    }

    public boolean buscarVertice(String nombre) {
        Nodo<Vertice> actual = vertices.obtenerCabeza();
        while (actual != null) {
            if (actual.obtenerDato().obtenerNombre().equals(nombre)) {
                return true;
            }
            actual = actual.obtenerSiguiente();
        }
        return false;
    }

    public ListaEnlazada<Arista> obtenerAdyacentes(String nombre) {
        return listaAdyacencia.get(nombre);
    }

    public void recorridoAnchura(String inicio) {
        if (!buscarVertice(inicio)) {
            System.out.println("Vértice no encontrado.");
            return;
        }

        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.offer(inicio);

        System.out.print("Recorrido en anchura (BFS): ");

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            System.out.print(actual + " ");

            ListaEnlazada<Arista> adyacentes = obtenerAdyacentes(actual);
            Nodo<Arista> nodo = adyacentes != null ? adyacentes.obtenerCabeza() : null;

            while (nodo != null) {
                String vecino = nodo.obtenerDato().obtenerVertice().obtenerNombre();
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.offer(vecino);
                }
                nodo = nodo.obtenerSiguiente();
            }
        }

        System.out.println();
    }

    public ArrayList<String> caminoAnchura(String inicio, String fin) {
        ArrayList<String> camino = new ArrayList<>();
        if (!buscarVertice(inicio) || !buscarVertice(fin)) return camino;

        Map<String, String> padre = new HashMap<>();
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.offer(inicio);
        padre.put(inicio, null);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            if (actual.equals(fin)) break;

            ListaEnlazada<Arista> adyacentes = obtenerAdyacentes(actual);
            Nodo<Arista> nodo = adyacentes != null ? adyacentes.obtenerCabeza() : null;

            while (nodo != null) {
                String vecino = nodo.obtenerDato().obtenerVertice().obtenerNombre();
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    padre.put(vecino, actual);
                    cola.offer(vecino);
                }
                nodo = nodo.obtenerSiguiente();
            }
        }

        if (!padre.containsKey(fin)) return camino;

        for (String v = fin; v != null; v = padre.get(v)) {
            camino.add(0, v);
        }

        return camino;
    }
}
