package Ejercicio2;

public class VerticeObjeto<T, E> {
    protected T informacion;
    protected int posicion;

    public VerticeObjeto(T informacion, int posicion) {
        this.informacion = informacion;
        this.posicion = posicion;
    }

    public T obtenerInformacion() {
        return informacion;
    }

    public int obtenerPosicion() {
        return posicion;
    }

    public void establecerInformacion(T informacion) {
        this.informacion = informacion;
    }

    public void establecerPosicion(int posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return informacion.toString();
    }
}
