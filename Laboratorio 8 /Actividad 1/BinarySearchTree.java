package bstreeInterface;

import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

public interface BinarySearchTree<E extends Comparable<E>> {
    void insert(E data) throws ItemDuplicated;
    boolean search(E data);
    void delete(E data) throws ItemNotFound, ExceptionIsEmpty;
    boolean isEmpty();
    void destroy();
    String toString();
}
