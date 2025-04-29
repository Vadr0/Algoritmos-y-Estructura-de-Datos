package ejercicios;

public class Ejerc03 {

    // Método estático y generico, inserta al final de una lista enlazada dado el PrimerNodo
    public static <T> Nodo<T> insertarAlFinal(Nodo<T> primerNodo, T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (primerNodo == null) {
            return nuevoNodo; // lista vacía = nuevo primerNodo
        } else {
            Nodo<T> nodoActual = primerNodo;
            while (nodoActual.getSiguienteNodo() != null) {
                nodoActual = nodoActual.getSiguienteNodo();
            }
            nodoActual.setSiguienteNodo(nuevoNodo);
            return primerNodo; // se mantiene el mismo primerNodo
        }
    }

    // imprimir la lista desde un nodo
    public static <T> void imprimirLista(Nodo<T> primerNodo) {
        Nodo<T> actual = primerNodo;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguienteNodo();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Nodo<String> primerNodo = null;

        // Insertar nodos
        primerNodo = insertarAlFinal(primerNodo, "A");
        primerNodo = insertarAlFinal(primerNodo, "B");
        primerNodo = insertarAlFinal(primerNodo, "C");

        imprimirLista(primerNodo);
    }
}
