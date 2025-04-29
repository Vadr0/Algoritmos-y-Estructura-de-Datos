package actividades;

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

    // Verificar si una lista esta vacia, viendo el valor de primer nodo
    public boolean isEmptyList() {
        return primerNodo == null;
    }

    // Mientras nodoActual no sea null, se seguira recorriendo la lista, aumentando el contador para el tamaño
    public int tamanioLista() {
        int contador = 0;
        Nodo<T> nodoActual = primerNodo;

        while (nodoActual != null) {
            contador++;
            nodoActual = nodoActual.getSiguienteNodo();
        }
        return contador;
    }

    // Si el primer nodo es null, entonces se destruye la lista
    public void destruirLista() {
        primerNodo = null;
    }

    // Se utilizo la estructura del metodo tamanioLista, añadiendole un condicional
    public boolean busca(T elementoABuscar) {
        Nodo<T> nodoActual = primerNodo;

        while (nodoActual != null) {
            if (nodoActual.getDato().equals(elementoABuscar)) {
                return true;
            }
            nodoActual = nodoActual.getSiguienteNodo();
        }
        return false;
    }

    // Creamos un nodo. Si la lista está vacía, se vuelve el primero. Si no, lo insertamos antes del actual primero.
    public void agregarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (primerNodo == null) {
            primerNodo = nuevoNodo;
        } else {
            nuevoNodo.setSiguienteNodo(primerNodo);
            primerNodo = nuevoNodo;
        }
    }

    // Creamos un nodo. Si la lista está vacía, se vuelve el primero. Si no, lo añadimos al final recorriendo hasta el último nodo.
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (primerNodo == null) {
            primerNodo = nuevoNodo;
        } else {
            Nodo<T> nodoActual = primerNodo;
            while (nodoActual.getSiguienteNodo() != null) {
                nodoActual = nodoActual.getSiguienteNodo();
            }
            nodoActual.setSiguienteNodo(nuevoNodo);
        }
    }

    // Elimina el nodo con el dato dado. Si es el primero, lo reemplaza. Si no, recorre y salta el nodo coincidente.
    public void eliminarNodo(T dato) {
        if (primerNodo == null) {
            System.out.println("Lista vacia.");
            return;
        }

        if (primerNodo.getDato().equals(dato)) {
            primerNodo = primerNodo.getSiguienteNodo();
            return;
        }

        Nodo<T> nodoActual = primerNodo;
        while (nodoActual.getSiguienteNodo() != null) {
            if (nodoActual.getSiguienteNodo().getDato().equals(dato)) {
                nodoActual.setSiguienteNodo(nodoActual.getSiguienteNodo().getSiguienteNodo());
                return;
            }
            nodoActual = nodoActual.getSiguienteNodo();
        }
        System.out.println("No se encontro el elemento");
    }

    // Metodo Adicional, imprimimos la lista, usando un metodo similar a la busquedasolo que esta vez imprimimos los valores.
    public void imprimirLista() {
        if (primerNodo == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo<T> nodoActual = primerNodo;
        while (nodoActual != null) {
            System.out.print(nodoActual.getDato() + " -> ");
            nodoActual = nodoActual.getSiguienteNodo();
        }
        System.out.println("null");
    }
}
