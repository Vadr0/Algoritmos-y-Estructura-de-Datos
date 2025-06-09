package Ejercicio1;

public class ListaEnlazada<T> {
    private Nodo<T> cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    public void insertarAlFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.obtenerSiguiente() != null) {
                actual = actual.obtenerSiguiente();
            }
            actual.establecerSiguiente(nuevo);
        }
    }

    public Nodo<T> obtenerCabeza() {
        return cabeza;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}
