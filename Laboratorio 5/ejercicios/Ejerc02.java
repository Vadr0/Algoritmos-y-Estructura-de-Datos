package ejercicios;

public class Ejerc02 {
    
    // Método genérico para invertir una lista enlazada
    public static <T> ListaEnlazada<T> invertirLista(ListaEnlazada<T> listaOriginal) {
        ListaEnlazada<T> listaInvertida = new ListaEnlazada<>();

        Nodo<T> nodoActual = listaOriginal.getPrimerNodo();
        while (nodoActual != null) {
            // Agregamos al inicio para invertir el orden
            listaInvertida.agregarAlInicio(nodoActual.getDato());
            nodoActual = nodoActual.getSiguienteNodo();
        }

        return listaInvertida;
    }

    public static void main(String[] args) {
        ListaEnlazada<String> lista = new ListaEnlazada<>();
        lista.agregarAlFinal("A");
        lista.agregarAlFinal("B");
        lista.agregarAlFinal("C");
        lista.agregarAlFinal("D");

        System.out.print("Lista original: ");
        lista.imprimirLista();

        ListaEnlazada<String> listaInvertida = invertirLista(lista);

        System.out.print("Lista invertida: ");
        listaInvertida.imprimirLista();
    }
}

