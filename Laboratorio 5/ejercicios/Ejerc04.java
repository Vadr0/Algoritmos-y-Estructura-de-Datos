package ejercicios;

public class Ejerc04 {

    public static <T> int contarNodos(ListaEnlazada<T> lista) {
        int contador = 0;
        Nodo<T> nodoActual = lista.getPrimerNodo();

        while (nodoActual != null) {
            contador++;
            nodoActual = nodoActual.getSiguienteNodo();
        }

        return contador;
    }

    public static void main(String[] args) {
        ListaEnlazada<Integer> listaNumeros = new ListaEnlazada<>();

        listaNumeros.agregarAlFinal(10);
        listaNumeros.agregarAlFinal(20);
        listaNumeros.agregarAlFinal(30);
        listaNumeros.agregarAlFinal(40);

        listaNumeros.imprimirLista();

        int total = contarNodos(listaNumeros);
        System.out.println("Cantidad total de nodos: " + total); 
    }
}

