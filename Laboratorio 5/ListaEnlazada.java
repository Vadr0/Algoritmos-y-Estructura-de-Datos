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

    
    
}
