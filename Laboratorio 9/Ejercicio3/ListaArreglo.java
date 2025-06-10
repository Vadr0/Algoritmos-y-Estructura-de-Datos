package Ejercicio3;

public class ListaArreglo<T> {
    private Object[] elementos;
    private int cantidad;

    public ListaArreglo() {
        elementos = new Object[100];
        cantidad = 0;
    }

    public void agregar(T dato) {
        elementos[cantidad++] = dato;
    }

    public T obtener(int i) {
        return (T) elementos[i];
    }

    public int tamaño() {
        return cantidad;
    }

    public boolean contiene(T dato) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i].equals(dato)) return true;
        }
        return false;
    }
}
