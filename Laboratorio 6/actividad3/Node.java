package actividad3;

// Es el mismo paquete que usamos en listas enlazadas, solo se modifico un poco
// segun los requerimientos de la actividad

public class Node<E> {
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public E getData() {
        return this.data;
    }
}
