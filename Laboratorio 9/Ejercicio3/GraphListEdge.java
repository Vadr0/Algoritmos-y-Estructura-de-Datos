package Ejercicio3;

public class GraphListEdge<V, E> {
    private ListaArreglo<VertexObj<V, E>> listaVertices;
    private ListaArreglo<EdgeObj<V, E>> listaAristas;

    public GraphListEdge() {
        listaVertices = new ListaArreglo<>();
        listaAristas = new ListaArreglo<>();
    }

    public void insertarVertice(V dato) {
        if (!buscarVertice(dato)) {
            VertexObj<V, E> nuevo = new VertexObj<>(dato, listaVertices.tamaño());
            listaVertices.agregar(nuevo);
        }
    }

    public boolean buscarVertice(V dato) {
        for (int i = 0; i < listaVertices.tamaño(); i++) {
            if (listaVertices.obtener(i).obtenerInformacion().equals(dato)) return true;
        }
        return false;
    }

    private VertexObj<V, E> obtenerVertice(V dato) {
        for (int i = 0; i < listaVertices.tamaño(); i++) {
            if (listaVertices.obtener(i).obtenerInformacion().equals(dato)) {
                return listaVertices.obtener(i);
            }
        }
        return null;
    }

    public void insertarArista(V d1, V d2) {
        if (!buscarArista(d1, d2)) {
            VertexObj<V, E> v1 = obtenerVertice(d1);
            VertexObj<V, E> v2 = obtenerVertice(d2);
            if (v1 != null && v2 != null) {
                EdgeObj<V, E> arista = new EdgeObj<>(v1, v2, null, listaAristas.tamaño());
                listaAristas.agregar(arista);
            }
        }
    }

    public boolean buscarArista(V d1, V d2) {
        for (int i = 0; i < listaAristas.tamaño(); i++) {
            EdgeObj<V, E> a = listaAristas.obtener(i);
            V v1 = a.obtenerVertice1().obtenerInformacion();
            V v2 = a.obtenerVertice2().obtenerInformacion();
            if ((v1.equals(d1) && v2.equals(d2)) || (v1.equals(d2) && v2.equals(d1))) {
                return true;
            }
        }
        return false;
    }

    public void bfs(V inicio) {
        boolean[] visitado = new boolean[listaVertices.tamaño()];
        Cola<VertexObj<V, E>> cola = new Cola<>();

        VertexObj<V, E> vInicio = obtenerVertice(inicio);
        if (vInicio == null) return;

        cola.encolar(vInicio);
        visitado[vInicio.obtenerPosicion()] = true;

        while (!cola.estaVacia()) {
            VertexObj<V, E> actual = cola.desencolar();
            System.out.print(actual.obtenerInformacion() + " ");

            for (int i = 0; i < listaAristas.tamaño(); i++) {
                EdgeObj<V, E> arista = listaAristas.obtener(i);
                VertexObj<V, E> vecino = null;

                if (arista.obtenerVertice1().equals(actual)) {
                    vecino = arista.obtenerVertice2();
                } else if (arista.obtenerVertice2().equals(actual)) {
                    vecino = arista.obtenerVertice1();
                }

                if (vecino != null && !visitado[vecino.obtenerPosicion()]) {
                    cola.encolar(vecino);
                    visitado[vecino.obtenerPosicion()] = true;
                }
            }
        }

        System.out.println();
    }

    public void imprimirGrafo() {
        System.out.println("Vértices:");
        for (int i = 0; i < listaVertices.tamaño(); i++) {
            System.out.println("- " + listaVertices.obtener(i).obtenerInformacion());
        }

        System.out.println("Aristas:");
        for (int i = 0; i < listaAristas.tamaño(); i++) {
            System.out.println(listaAristas.obtener(i));
        }
    }
}
