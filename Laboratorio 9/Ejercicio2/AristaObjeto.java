package Ejercicio2;

public class AristaObjeto<T, E> {
    private E informacion;
    private VerticeObjeto<T, E> vertice1;
    private VerticeObjeto<T, E> vertice2;
    private int posicion;

    public AristaObjeto(VerticeObjeto<T, E> v1, VerticeObjeto<T, E> v2, E info, int posicion) {
        this.vertice1 = v1;
        this.vertice2 = v2;
        this.informacion = info;
        this.posicion = posicion;
    }

    public E obtenerInformacion() {
        return informacion;
    }

    public VerticeObjeto<T, E> obtenerVertice1() {
        return vertice1;
    }

    public VerticeObjeto<T, E> obtenerVertice2() {
        return vertice2;
    }

    public int obtenerPosicion() {
        return posicion;
    }

    public String toString() {
        return "(" + vertice1 + " - " + vertice2 + ", peso: " + informacion + ")";
    }
}

