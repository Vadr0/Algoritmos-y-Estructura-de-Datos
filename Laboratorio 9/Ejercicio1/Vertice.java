package Ejercicio1;

public class Vertice {
    private String nombre;

    public Vertice(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public boolean esIgual(Vertice otro) {
        return this.nombre.equals(otro.obtenerNombre());
    }

    @Override
    public String toString() {
        return nombre;
    }
}
