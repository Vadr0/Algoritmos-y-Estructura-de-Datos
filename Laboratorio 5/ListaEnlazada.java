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
    boolean isEmptyList(){
        return primerNodo == null;
    }
    
}
