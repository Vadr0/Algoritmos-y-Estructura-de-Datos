package ejercicios;

public class Ejerc01 {
    // Método genérico para buscar un elemento en una lista enlazada
    public static <T> boolean buscarElemento(ListaEnlazada<T> lista, T valor) {
        Nodo<T> nodoActual = lista.getPrimerNodo();
        
        while (nodoActual != null) {
            if (nodoActual.getDato().equals(valor)) {
                return true;
            }
            nodoActual = nodoActual.getSiguienteNodo();
        }

        return false;
    }

    public static void main(String[] args) {

        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.agregarAlFinal(10);
        lista.agregarAlFinal(20);
        lista.agregarAlFinal(30);

   
        System.out.print("Lista: ");
        lista.imprimirLista();

        // Buscar elementos en la lista
        int buscar1 = 20;
        int buscar2 = 40;

        System.out.println("¿Contiene " + buscar1 + "? " + buscarElemento(lista, buscar1)); 
        System.out.println("¿Contiene " + buscar2 + "? " + buscarElemento(lista, buscar2)); 
    }
}
