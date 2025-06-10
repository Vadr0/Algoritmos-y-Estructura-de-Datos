package Ejercicio2;

import java.util.*;

public class GrafoListaArista<T, E> {
    private List<VerticeObjeto<T, E>> listaVertices;
    private List<AristaObjeto<T, E>> listaAristas;

    public GrafoListaArista() {
        this.listaVertices = new ArrayList<>();
        this.listaAristas = new ArrayList<>();
    }

    public void insertarVertice(T dato) {
        if (!buscarVertice(dato)) {
            VerticeObjeto<T, E> vertice = new VerticeObjeto<>(dato, listaVertices.size());
            listaVertices.add(vertice);
        }
    }

    public boolean buscarVertice(T dato) {
        return listaVertices.stream().anyMatch(v -> v.obtenerInformacion().equals(dato));
    }

    public boolean buscarArista(T dato1, T dato2) {
        for (AristaObjeto<T, E> arista : listaAristas) {
            T v1 = arista.obtenerVertice1().obtenerInformacion();
            T v2 = arista.obtenerVertice2().obtenerInformacion();
            if ((v1.equals(dato1) && v2.equals(dato2)) || (v1.equals(dato2) && v2.equals(dato1))) {
                return true;
            }
        }
        return false;
    }

    public void insertarArista(T dato1, T dato2, E peso) {
        if (!buscarArista(dato1, dato2)) {
            VerticeObjeto<T, E> vertice1 = obtenerVertice(dato1);
            VerticeObjeto<T, E> vertice2 = obtenerVertice(dato2);
            if (vertice1 != null && vertice2 != null) {
                AristaObjeto<T, E> nueva = new AristaObjeto<>(vertice1, vertice2, peso, listaAristas.size());
                listaAristas.add(nueva);
            }
        }
    }

    private VerticeObjeto<T, E> obtenerVertice(T dato) {
        for (VerticeObjeto<T, E> vertice : listaVertices) {
            if (vertice.obtenerInformacion().equals(dato)) {
                return vertice;
            }
        }
        return null;
    }

    public void recorridoAnchura(T inicio) {
        Set<T> visitados = new HashSet<>();
        Queue<T> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.offer(inicio);

        while (!cola.isEmpty()) {
            T actual = cola.poll();
            System.out.print(actual + " ");

            for (AristaObjeto<T, E> arista : listaAristas) {
                T vecino = null;
                if (arista.obtenerVertice1().obtenerInformacion().equals(actual)) {
                    vecino = arista.obtenerVertice2().obtenerInformacion();
                } else if (arista.obtenerVertice2().obtenerInformacion().equals(actual)) {
                    vecino = arista.obtenerVertice1().obtenerInformacion();
                }

                if (vecino != null && !visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.offer(vecino);
                }
            }
        }
        System.out.println();
    }

    public void imprimirGrafo() {
        System.out.println("Vértices:");
        for (VerticeObjeto<T, E> v : listaVertices) {
            System.out.println("- " + v.obtenerInformacion());
        }

        System.out.println("Aristas:");
        for (AristaObjeto<T, E> a : listaAristas) {
            System.out.println(a);
        }
    }
}
