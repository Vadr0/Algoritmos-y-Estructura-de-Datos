package Ejercicio3;

public class VertexObj<V, E> {
    protected V info;
    protected int posicion;

    public VertexObj(V info, int posicion) {
        this.info = info;
        this.posicion = posicion;
    }

    public V obtenerInformacion() {
        return info;
    }

    public int obtenerPosicion() {
        return posicion;
    }

    public String toString() {
        return info.toString();
    }
}
