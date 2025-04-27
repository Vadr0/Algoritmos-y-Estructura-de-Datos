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
    
    // Para destruir la lista, simplemente volvemos a poner el primer nodo como nulo.
    public void destruirLista() {
        primerNodo = null;
    }

    // Se utilizo la estructura del metodo tamanioLista, añadiendole un condicional, y si no se encuentra el valor, retornaria -1
    public int busca(T elementoABuscar){
        int posicion = 0;
        Nodo<T> nodoActual = primerNodo;

        while(nodoActual != null){
            if (nodoActual.getDato().equals(elementoABuscar)){
                return posicion;
            }
        nodoActual = nodoActual.getSiguienteNodo();
        posicion++;
        }
        return -1;
    }

    //Para añadir al inicio, creamos un nuevo nodo, si el primer nodo esta vacio, entonces el nuevo nodo es el primer nodo
    // si no esta vacio, vuelve el primer nodo el siguiente nodo, y el nuevo nodo el primero
    public void agregarAlInicio(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        if (primerNodo == null){
            primerNodo = nuevoNodo;
        } else {
            nuevoNodo.setSiguienteNodo(primerNodo);
            primerNodo = nuevoNodo;
        }
    }

    // Para agregar al final, sigue una logica similar a a agregar al inicio, si el primer nodo es nulo, el nuevo nodo se vuelve el primero
    // si no es nulo, entonces iniciamos una busqueda por todos los nodos, hasta que el siguiente nodo sea null, una vez que lo encontremos
    // hacemos que el siguiente nodo reciba el valor del nuevo nodo
    public void agregarAlFinal(T dato){
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (primerNodo == null){
            primerNodo = nuevoNodo;
        } else {
            Nodo<T> nodoActual = primerNodo;
            while (nodoActual.getSiguienteNodo() != null) {
                nodoActual = nodoActual.getSiguienteNodo();
            }
            nodoActual.setSiguienteNodo(nuevoNodo);
        }
    }
}
