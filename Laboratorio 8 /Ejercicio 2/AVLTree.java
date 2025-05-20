package Ejercicio2;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

    @Override
    public void insert(E key) {
        root = insert((NodeAVL<E>) root, key);
    }

    private NodeAVL<E> insert(NodeAVL<E> node, E key) {
        if (node == null) return new NodeAVL<>(key);

        int cmp = key.compareTo(node.data);

        if (cmp < 0) {
            node.left = insert((NodeAVL<E>) node.left, key);
            node = balanceToRight(node);
        } else if (cmp > 0) {
            node.right = insert((NodeAVL<E>) node.right, key);
            node = balanceToLeft(node);
        }

        return node;
    }

    private NodeAVL<E> balanceToLeft(NodeAVL<E> node) {
        NodeAVL<E> child = (NodeAVL<E>) node.right;
        if (height(child) - height((NodeAVL<E>) node.left) > 1) {
            if (height((NodeAVL<E>) child.right) >= height((NodeAVL<E>) child.left)) {
                node = rotateSL(node);
            } else {
                node.right = rotateSR(child);
                node = rotateSL(node);
            }
        }
        return node;
    }

    private NodeAVL<E> balanceToRight(NodeAVL<E> node) {
        NodeAVL<E> child = (NodeAVL<E>) node.left;
        if (height(child) - height((NodeAVL<E>) node.right) > 1) {
            if (height((NodeAVL<E>) child.left) >= height((NodeAVL<E>) child.right)) {
                node = rotateSR(node);
            } else {
                node.left = rotateSL(child);
                node = rotateSR(node);
            }
        }
        return node;
    }

    private NodeAVL<E> rotateSL(NodeAVL<E> node) {
        NodeAVL<E> newRoot = (NodeAVL<E>) node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }

    private NodeAVL<E> rotateSR(NodeAVL<E> node) {
        NodeAVL<E> newRoot = (NodeAVL<E>) node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    protected int height(NodeAVL<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height((NodeAVL<E>) node.left), height((NodeAVL<E>) node.right));
    }

    public void printPreOrder() {
        printPreOrder((NodeAVL<E>) root);
    }

    private void printPreOrder(NodeAVL<E> node) {
        if (node != null) {
            System.out.println(node);
            printPreOrder((NodeAVL<E>) node.left);
            printPreOrder((NodeAVL<E>) node.right);
        }
    }
}
