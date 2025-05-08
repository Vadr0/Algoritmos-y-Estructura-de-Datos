class Nodo<T>{
    T dato;
    Nodo<T> siguienteNodo;

    //Constructor
    public Nodo(T dato){
        this.dato = dato;
        this.siguienteNodo = null;
    }
}


public class ListaEnlazada<T> {
    private Nodo<T> primerNodo;

    public ListaEnlazada() {
        primerNodo = null;
    }

    public void setPrimerNodo(Nodo<T> primerNodo) {
        this.primerNodo = primerNodo;
    }

    public Nodo<T> getPrimerNodo() {
        return primerNodo;
    }

    // Si el primer nodo es igual a null (es decir la lista esta vacia), retornara
    // true, sino retornara false
    public boolean isEmptyList() {
        return primerNodo == null;
    }

    // Se inicia un contador, y un nodoActual, que equivale al primer nodo
    // Mientras que el valor del nodoActual no sea null, se seguira recorriendo la
    // lista, cambiando el nodoActual por el siguiente nodo.
    public int tamanioLista() {
        int contador = 0;
        Nodo<T> nodoActual = primerNodo;

        while (nodoActual != null) {
            contador++;
            nodoActual = nodoActual.siguienteNodo;
        }
        return contador;
    }

    // Para destruir la lista, simplemente volvemos a poner el primer nodo como
    // nulo.
    public void destruirLista() {
        primerNodo = null;
    }

    // Se utilizo la estructura del metodo tamanioLista, añadiendole un condicional,
    // y si no se encuentra el valor, retornaria -1
    public int busca(T elementoABuscar) {
        int posicion = 0;
        Nodo<T> nodoActual = primerNodo;

        while (nodoActual != null) {
            if (nodoActual.dato.equals(elementoABuscar)) {
                return posicion;
            }
            nodoActual = nodoActual.siguienteNodo;
            posicion++;
        }
        return -1;
    }

    // Para añadir al inicio, creamos un nuevo nodo, si el primer nodo esta vacio,
    // entonces el nuevo nodo es el primer nodo
    // si no esta vacio, vuelve el primer nodo el siguiente nodo, y el nuevo nodo el
    // primero
    public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (primerNodo == null) {
            primerNodo = nuevoNodo;
        } else {
            nuevoNodo.siguienteNodo = nuevoNodo;
            primerNodo = nuevoNodo;
        }
    }

    // Para agregar al final, sigue una logica similar a a agregar al inicio, si el
    // primer nodo es nulo, el nuevo nodo se vuelve el primero
    // si no es nulo, entonces iniciamos una busqueda por todos los nodos, hasta que
    // el siguiente nodo sea null, una vez que lo encontremos
    // hacemos que el siguiente nodo reciba el valor del nuevo nodo
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (primerNodo == null) {
            primerNodo = nuevoNodo;
        } else {
            Nodo<T> nodoActual = primerNodo;
            while (nodoActual.siguienteNodo != null) {
                nodoActual = nodoActual.siguienteNodo;
            }
            nodoActual.siguienteNodo = nuevoNodo;
        }
    }

    // Para eliminar un elemento, primero comprobamos, si la lista esta vacia
    // Si el elemento que buscamos es parte del primer nodo, entonces simplemente volvemos al siguiente nodo como el primer nodo
    // Si no es ninguna de esas opciones, iteramos la lista, mientras que no sea el ultimo elemento en ella
        // si el valor del siguiente nodo, al nodo actual, es el valor que buscamos
        // entonces, el siguiente nodo, se convierte en el siguiente del siguiente
    public void eliminarNodo(T dato) {
        if (primerNodo == null) {
            System.out.println("Lista vacia.");
            return;
        }

        if (primerNodo.dato.equals(dato)) {
            primerNodo = primerNodo.siguienteNodo;
            return;
        }

        Nodo<T> nodoActual = primerNodo;
        while (nodoActual.siguienteNodo != null) {
            if (nodoActual.siguienteNodo.dato.equals(dato)) {
                nodoActual.siguienteNodo = nodoActual.siguienteNodo.siguienteNodo;
                return;
            }
            nodoActual = nodoActual.siguienteNodo;
        }
        System.out.println("No se encontro el elemento");
    }

    // Metodo Adicional, imprimimos la lista, primero verificamos que la lista no este vacia, luego usamos un metodo similar a la busqueda 
    // o a la eliminacion, solo que esta vez imprimimos los valores junto a una flecha, y si no hay siguiente elemento un null
    public void imprimirLista() {
        if (primerNodo == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo<T> nodoActual = primerNodo;
        while (nodoActual != null) {
            System.out.print(nodoActual.dato + " -> ");
            nodoActual = nodoActual.siguienteNodo;
        }
        System.out.println("null");
    }
}
