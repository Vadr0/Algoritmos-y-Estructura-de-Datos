public class ListaEnlazada<T> {
    private Nodo<T> primerNodo;

    public ListaEnlazada(){
        primerNodo = null;
    }

    public void setPrimerNodo(Nodo<T> primerNodo) {
        this.primerNodo = primerNodo;
    }
    public Nodo<T> getPrimerNodo() {
        return primerNodo;
    }
    
    // Si el primer nodo es igual a null (es decir la lista esta vacia), retornara true, sino retornara false
    public boolean isEmptyList(){
        return primerNodo == null;
    }

    // Se inicia un contador, y un nodoActual, que equivale al primer nodo
    // Mientras que el valor del nodoActual no sea null, se seguira recorriendo la lista, cambiando el nodoActual por el siguiente nodo.
    public int tamanioLista(){
        int contador = 0;
        Nodo<T> nodoActual = primerNodo;
        
        while (nodoActual != null){
            contador++;
            nodoActual = nodoActual.getSiguienteNodo();
        }
        return contador;
    }


    
}
