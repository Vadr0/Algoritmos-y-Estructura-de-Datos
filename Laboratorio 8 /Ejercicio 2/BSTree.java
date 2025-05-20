package Ejercicio2;

public class BSTree<E extends Comparable<E>> {
    protected Node<E> root;

    public void insert(E key) {
        root = insert(root, key);
    }

    protected Node<E> insert(Node<E> node, E key) {
        if (node == null) return new Node<>(key);

        int cmp = key.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, key);
        } else if (cmp > 0) {
            node.right = insert(node.right, key);
        }

        return node;
    }

    public boolean search(E key) {
        return search(root, key);
    }

    protected boolean search(Node<E> node, E key) {
        if (node == null) return false;

        int cmp = key.compareTo(node.data);
        if (cmp == 0) return true;
        else if (cmp < 0) return search(node.left, key);
        else return search(node.right, key);
    }

    public int height() {
        return height(root);
    }

    protected int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
