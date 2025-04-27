public class Main {
    public static void main(String[] args) {
        ListaEnlazada<Integer> listaNumeros = new ListaEnlazada<>();        
        
        System.out.println(listaNumeros.isEmptyList());
        System.out.println(listaNumeros.tamanioLista());
        Nodo<Integer> nodo1 = new Nodo<>(5);
        System.out.println(listaNumeros.busca(5));


        // prueba con un dato agregado
        listaNumeros.setPrimerNodo(nodo1);
        System.out.println(listaNumeros.isEmptyList());
        System.out.println(listaNumeros.tamanioLista());
        System.out.println(listaNumeros.busca(5));

        //Prueba de agregar valores
        listaNumeros.agregarAlFinal(4);
        listaNumeros.agregarAlInicio(26);

        System.out.println(listaNumeros.busca(26));
        System.out.println(listaNumeros.busca(82));
        System.out.println(listaNumeros.busca(4));


    }
}
