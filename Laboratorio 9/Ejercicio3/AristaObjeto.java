package Ejercicio3;

public class AristaObjeto<T, E> {
    protected E informacion;
    protected VerticeObjeto<T, E> vertice1;
    protected VerticeObjeto<T, E> vertice2;
    protected int posicion;

    public AristaObjeto(VerticeObjeto<T, E> vertice1, VerticeObjeto<T, E> vertice2, E informacion, int posicion) {
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.informacion = informacion;
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

    @Override
    public String toString() {
        return "(" + vertice1 + " - " + vertice2 + ", peso: " + informacion + ")";
    }
}
