package Ejercicio2;

public class Node<E extends Comparable<E>> {
    protected E data;
    protected Node<E> left, right;

    public Node(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
