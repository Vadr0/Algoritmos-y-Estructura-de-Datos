package ejercicios;

public class Ejerc03 {
    public static <T> void insertarAlFinal(ListaEnlazada<T> lista, T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (lista.getPrimerNodo() == null) {
            lista.setPrimerNodo(nuevoNodo);
        } else {
            Nodo<T> nodoActual = lista.getPrimerNodo();
            while (nodoActual.getSiguienteNodo() != null) {
                nodoActual = nodoActual.getSiguienteNodo();
            }
            nodoActual.setSiguienteNodo(nuevoNodo);
        }
    }

    public static void main(String[] args) {
        ListaEnlazada<String> lista = new ListaEnlazada<>();

        insertarAlFinal(lista, "A");
        insertarAlFinal(lista, "B");
        insertarAlFinal(lista, "C");
        insertarAlFinal(lista, "D");
        insertarAlFinal(lista, "E");

        lista.imprimirLista();
    }
}
