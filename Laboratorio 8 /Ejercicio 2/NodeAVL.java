package Ejercicio2;

public class NodeAVL<E extends Comparable<E>> extends Node<E> {
    protected int bf; // balance factor

    public NodeAVL(E data) {
        super(data);
        this.bf = 0;
    }

    @Override
    public String toString() {
        return data + " (bf=" + bf + ")";
    }
}
