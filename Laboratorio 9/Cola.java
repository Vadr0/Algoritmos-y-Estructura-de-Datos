package Ejercicio3;

public class Cola<T> {
    private Object[] datos;
    private int frente;
    private int fin;
    private int tamaño;

    public Cola() {
        datos = new Object[100];
        frente = 0;
        fin = 0;
        tamaño = 0;
    }

    public void encolar(T elemento) {
        datos[fin++] = elemento;
        tamaño++;
    }

    public T desencolar() {
        if (estaVacia()) return null;
        tamaño--;
        return (T) datos[frente++];
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }
}
