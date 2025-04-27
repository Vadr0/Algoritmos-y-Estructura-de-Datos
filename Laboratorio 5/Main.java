public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> listaNumeros = new ListaEnlazada<>();        
        
        System.out.println(listaNumeros.isEmptyList());
        System.out.println(listaNumeros.tamanioLista());
        Nodo<Integer> nodo1 = new Nodo<>(5); 

        listaNumeros.setPrimerNodo(nodo1);
        System.out.println(listaNumeros.isEmptyList());
        System.out.println(listaNumeros.tamanioLista());


    }
}
