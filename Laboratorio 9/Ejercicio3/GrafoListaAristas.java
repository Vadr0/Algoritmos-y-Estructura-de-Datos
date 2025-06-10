package Ejercicio3;

import java.util.*;

public class GrafoListaAristas<T, E> {
    private List<VerticeObjeto<T, E>> listaVertices;
    private List<AristaObjeto<T, E>> listaAristas;

    public GrafoListaAristas() {
        this.listaVertices = new ArrayList<>();
        this.listaAristas = new ArrayList<>();
    }

    public void insertarVertice(T dato) {
        if (!buscarVertice(dato)) {
            VerticeObjeto<T, E> nuevo = new VerticeObjeto<>(dato, listaVertices.size());
            listaVertices.add(nuevo);
        }
    }

    public boolean buscarVertice(T dato) {
        for (VerticeObjeto<T, E> vertice : listaVertices) {
            if (vertice.obtenerInformacion().equals(dato)) {
                return true;
            }
        }
        return false;
    }

    public void insertarArista(T dato1, T dato2, E peso) {
        if (!buscarArista(dato1, dato2)) {
            VerticeObjeto<T, E> v1 = obtenerVertice(dato1);
            VerticeObjeto<T, E> v2 = obtenerVertice(dato2);
            if (v1 != null && v2 != null) {
                AristaObjeto<T, E> arista = new AristaObjeto<>(v1, v2, peso, listaAristas.size());
                listaAristas.add(arista);
            }
        }
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

    private VerticeObjeto<T, E> obtenerVertice(T dato) {
        for (VerticeObjeto<T, E> vertice : listaVertices) {
            if (vertice.obtenerInformacion().equals(dato)) {
                return vertice;
            }
        }
        return null;
    }

    public void recorridoProfundidad(T inicio) {
        Set<T> visitados = new HashSet<>();
        profundidadRecursiva(inicio, visitados);
        System.out.println();
    }

    private void profundidadRecursiva(T actual, Set<T> visitados) {
        if (visitados.contains(actual)) return;
        System.out.print(actual + " ");
        visitados.add(actual);

        for (AristaObjeto<T, E> arista : listaAristas) {
            T vecino = null;
            if (arista.obtenerVertice1().obtenerInformacion().equals(actual)) {
                vecino = arista.obtenerVertice2().obtenerInformacion();
            } else if (arista.obtenerVertice2().obtenerInformacion().equals(actual)) {
                vecino = arista.obtenerVertice1().obtenerInformacion();
            }

            if (vecino != null && !visitados.contains(vecino)) {
                profundidadRecursiva(vecino, visitados);
            }
        }
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
