package Lab8;

public class AVLTree<E extends Comparable<E>> {
    private NodeAVL<E> root;

    public void insert(E key) {
        root = insert(key, root);
    }

    private NodeAVL<E> insert(E key, NodeAVL<E> node) {
        if (node == null) return new NodeAVL<>(key);

        int cmp = key.compareTo(node.data);

        if (cmp < 0) {
            node.left = insert(key, node.left);
            node = balanceToRight(node);
        } else if (cmp > 0) {
            node.right = insert(key, node.right);
            node = balanceToLeft(node);
        }

        return node;
    }

    private NodeAVL<E> balanceToLeft(NodeAVL<E> node) {
        if (height(node.right) - height(node.left) > 1) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
        return node;
    }

    private NodeAVL<E> balanceToRight(NodeAVL<E> node) {
        if (height(node.left) - height(node.right) > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
        return node;
    }

    private NodeAVL<E> rotateLeft(NodeAVL<E> a) {
        NodeAVL<E> b = a.right;
        a.right = b.left;
        b.left = a;
        return b;
    }

    private NodeAVL<E> rotateRight(NodeAVL<E> a) {
        NodeAVL<E> b = a.left;
        a.left = b.right;
        b.right = a;
        return b;
    }

    private int height(NodeAVL<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printPreOrder(NodeAVL<E> node) {
        if (node != null) {
            System.out.println(node);
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }
}
