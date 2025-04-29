package ejercicios;

public class Ejerc05 {
    public static <T> boolean sonIguales(ListaEnlazada<T> lista1, ListaEnlazada<T> lista2) {
        Nodo<T> nodo1 = lista1.getPrimerNodo();
        Nodo<T> nodo2 = lista2.getPrimerNodo();

        while (nodo1 != null && nodo2 != null) {
            if (!nodo1.getDato().equals(nodo2.getDato())) {
                return false;
            }
            nodo1 = nodo1.getSiguienteNodo();
            nodo2 = nodo2.getSiguienteNodo();
        }

        // los dos valores deberian ser nulos si tienen la misma longitud
        return nodo1 == null && nodo2 == null;
    }

    public static void main(String[] args) {
        ListaEnlazada<Integer> listaA = new ListaEnlazada<>();
        ListaEnlazada<Integer> listaB = new ListaEnlazada<>();

        listaA.agregarAlFinal(1);
        listaA.agregarAlFinal(2);
        listaA.agregarAlFinal(3);

        listaB.agregarAlFinal(1);
        listaB.agregarAlFinal(2);
        listaB.agregarAlFinal(3);

        boolean iguales = sonIguales(listaA, listaB);
        System.out.println("son iguales? " + iguales); // true

        listaB.agregarAlFinal(4);
        iguales = sonIguales(listaA, listaB);
        System.out.println("son iguales ahora? " + iguales); // false
    }
}
