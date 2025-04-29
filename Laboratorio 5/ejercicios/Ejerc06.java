package ejercicios;

public class Ejerc06 {

    public static <T> ListaEnlazada<T> concatenarListas(ListaEnlazada<T> lista1, ListaEnlazada<T> lista2) {
        ListaEnlazada<T> listaConcatenada = new ListaEnlazada<>();

        //primera lista
        Nodo<T> nodo1 = lista1.getPrimerNodo();
        while (nodo1 != null) {
            listaConcatenada.agregarAlFinal(nodo1.getDato());
            nodo1 = nodo1.getSiguienteNodo();
        }

        //segunda lista
        Nodo<T> nodo2 = lista2.getPrimerNodo();
        while (nodo2 != null) {
            listaConcatenada.agregarAlFinal(nodo2.getDato());
            nodo2 = nodo2.getSiguienteNodo();
        }

        return listaConcatenada;
    }

    public static void main(String[] args) {

        ListaEnlazada<Integer> listaA = new ListaEnlazada<>();
        ListaEnlazada<Integer> listaB = new ListaEnlazada<>();

        listaA.agregarAlFinal(1);
        listaA.agregarAlFinal(2);
        listaA.agregarAlFinal(3);

        listaB.agregarAlFinal(4);
        listaB.agregarAlFinal(5);
        listaB.agregarAlFinal(6);

        // Concatenar las listas
        ListaEnlazada<Integer> listaConcatenada = concatenarListas(listaA, listaB);

        listaConcatenada.imprimirLista();  
    }
}
