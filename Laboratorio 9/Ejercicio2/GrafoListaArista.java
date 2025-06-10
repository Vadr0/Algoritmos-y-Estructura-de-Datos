package Ejercicio2;

public class GrafoListaArista<T, E> {
    private VerticeObjeto<T, E>[] vertices;
    private AristaObjeto<T, E>[] aristas;
    private int cantidadVertices;
    private int cantidadAristas;

    public GrafoListaArista() {
        this.vertices = new VerticeObjeto[100];
        this.aristas = new AristaObjeto[100];
        this.cantidadVertices = 0;
        this.cantidadAristas = 0;
    }

    public void insertarVertice(T dato) {
        if (!buscarVertice(dato)) {
            vertices[cantidadVertices] = new VerticeObjeto<>(dato, cantidadVertices);
            cantidadVertices++;
        }
    }

    public boolean buscarVertice(T dato) {
        for (int i = 0; i < cantidadVertices; i++) {
            if (vertices[i].obtenerInformacion().equals(dato)) {
                return true;
            }
        }
        return false;
    }

    public VerticeObjeto<T, E> obtenerVertice(T dato) {
        for (int i = 0; i < cantidadVertices; i++) {
            if (vertices[i].obtenerInformacion().equals(dato)) {
                return vertices[i];
            }
        }
        return null;
    }

    public boolean buscarArista(T dato1, T dato2) {
        for (int i = 0; i < cantidadAristas; i++) {
            AristaObjeto<T, E> arista = aristas[i];
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
            VerticeObjeto<T, E> v1 = obtenerVertice(dato1);
            VerticeObjeto<T, E> v2 = obtenerVertice(dato2);
            if (v1 != null && v2 != null) {
                aristas[cantidadAristas] = new AristaObjeto<>(v1, v2, peso, cantidadAristas);
                cantidadAristas++;
            }
        }
    }

    public void recorridoAnchura(T inicio) {
        boolean[] visitado = new boolean[cantidadVertices];
        T[] cola = (T[]) new Object[cantidadVertices];
        int frente = 0, fin = 0;

        VerticeObjeto<T, E> vInicio = obtenerVertice(inicio);
        if (vInicio == null) return;

        int posInicio = vInicio.obtenerPosicion();
        visitado[posInicio] = true;
        cola[fin++] = inicio;

        while (frente < fin) {
            T actual = cola[frente++];
            System.out.print(actual + " ");

            for (int i = 0; i < cantidadAristas; i++) {
                AristaObjeto<T, E> arista = aristas[i];
                T origen = arista.obtenerVertice1().obtenerInformacion();
                T destino = arista.obtenerVertice2().obtenerInformacion();

                if (origen.equals(actual)) {
                    int posDestino = arista.obtenerVertice2().obtenerPosicion();
                    if (!visitado[posDestino]) {
                        cola[fin++] = destino;
                        visitado[posDestino] = true;
                    }
                } else if (destino.equals(actual)) {
                    int posOrigen = arista.obtenerVertice1().obtenerPosicion();
                    if (!visitado[posOrigen]) {
                        cola[fin++] = origen;
                        visitado[posOrigen] = true;
                    }
                }
            }
        }
        System.out.println();
    }

    public void imprimirGrafo() {
        System.out.println("Vértices:");
        for (int i = 0; i < cantidadVertices; i++) {
            System.out.println("- " + vertices[i].obtenerInformacion());
        }

        System.out.println("Aristas:");
        for (int i = 0; i < cantidadAristas; i++) {
            System.out.println(aristas[i]);
        }
    }
}

