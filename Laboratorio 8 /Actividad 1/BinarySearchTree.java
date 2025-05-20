package bstreeInterface;

public interface BinarySearchTree<E extends Comparable<E>> {
    void insert(E data);
    boolean search(E data);
    void delete(E data);
    boolean isEmpty();
    void destroy();
    String toString();
}
