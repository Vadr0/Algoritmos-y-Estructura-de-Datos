import Node.Node;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;
import Actividad_1.LinkedBST;
import estructuras.LinkedQueue;
import estructuras.Queue;

public class AVLTreeWithRotationLogging<E extends Comparable<E>> extends LinkedBST<E> {

    protected static class NodeAVL<E> extends Node<E> {
        int bf;

        public NodeAVL(E data) {
            super(data);
            bf = 0;
        }

        @Override
        public String toString() {
            return data + "(bf:" + bf + ")";
        }
    }

    private boolean heightChanged;

    // To hold a rotation log entry for summary output
    private static class RotationLog {
        String rotationType;
        Object rootAfterRotation;

        RotationLog(String rotationType, Object rootAfterRotation) {
            this.rotationType = rotationType;
            this.rootAfterRotation = rootAfterRotation;
        }
    }

    // For recording rotations to print later
    private final java.util.List<RotationLog> rotationLogs = new java.util.ArrayList<>();

    @Override
    public void insert(E x) throws ItemDuplicated {
        heightChanged = false;
        root = insert((NodeAVL<E>) root, x);
    }

    private NodeAVL<E> insert(NodeAVL<E> node, E x) throws ItemDuplicated {
        if (node == null) {
            heightChanged = true;
            return new NodeAVL<>(x);
        }

        int cmp = x.compareTo(node.data);
        if (cmp == 0) throw new ItemDuplicated(x + " ya se encuentra en el árbol");

        if (cmp < 0) {
            node.left = insert((NodeAVL<E>) node.left, x);
            if (heightChanged) {
                switch (node.bf) {
                    case 1 -> {
                        node.bf = 0;
                        heightChanged = false;
                    }
                    case 0 -> node.bf = -1;
                    case -1 -> {
                        System.out.println("Rotación necesaria al insertar: balanceRight en nodo " + node.data);
                        System.out.println("Árbol antes de rotar:");
                        printTree();
                        node = balanceRight(node);
                        System.out.println("Árbol después de rotar:");
                        printTree();
                        System.out.println("-------------------------");
                        heightChanged = false;
                    }
                }
            }
        } else {
            node.right = insert((NodeAVL<E>) node.right, x);
            if (heightChanged) {
                switch (node.bf) {
                    case -1 -> {
                        node.bf = 0;
                        heightChanged = false;
                    }
                    case 0 -> node.bf = 1;
                    case 1 -> {
                        System.out.println("Rotación necesaria al insertar: balanceLeft en nodo " + node.data);
                        System.out.println("Árbol antes de rotar:");
                        printTree();
                        node = balanceLeft(node);
                        System.out.println("Árbol después de rotar:");
                        printTree();
                        System.out.println("-------------------------");
                        heightChanged = false;
                    }
                }
            }
        }

        return node;
    }

    @Override
    public void delete(E x) throws ItemNotFound, ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("El árbol está vacío");
        heightChanged = false;
        root = delete((NodeAVL<E>) root, x);
    }

    private NodeAVL<E> delete(NodeAVL<E> node, E x) throws ItemNotFound {
        if (node == null) throw new ItemNotFound(x + " no encontrado en el árbol");

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete((NodeAVL<E>) node.left, x);
            if (heightChanged) {
                System.out.println("Rotación necesaria al eliminar: adjustAfterDeleteRight en nodo " + node.data);
                System.out.println("Árbol antes de ajustar derecha:");
                printTree();
                node = adjustAfterDeleteRight(node);
                System.out.println("Árbol después de ajustar derecha:");
                printTree();
                System.out.println("-------------------------");
            }
        } else if (cmp > 0) {
            node.right = delete((NodeAVL<E>) node.right, x);
            if (heightChanged) {
                System.out.println("Rotación necesaria al eliminar: adjustAfterDeleteLeft en nodo " + node.data);
                System.out.println("Árbol antes de ajustar izquierda:");
                printTree();
                node = adjustAfterDeleteLeft(node);
                System.out.println("Árbol después de ajustar izquierda:");
                printTree();
                System.out.println("-------------------------");
            }
        } else {
            if (node.left == null || node.right == null) {
                node = (NodeAVL<E>) (node.left != null ? node.left : node.right);
                heightChanged = true;
            } else {
                NodeAVL<E> successor = findMin((NodeAVL<E>) node.right);
                node.data = successor.data;
                node.right = delete((NodeAVL<E>) node.right, successor.data);
                if (heightChanged) {
                    System.out.println("Rotación necesaria tras eliminar y reemplazar sucesor: adjustAfterDeleteLeft en nodo " + node.data);
                    System.out.println("Árbol antes de ajustar izquierda:");
                    printTree();
                    node = adjustAfterDeleteLeft(node);
                    System.out.println("Árbol después de ajustar izquierda:");
                    printTree();
                    System.out.println("-------------------------");
                }
            }
        }

        return node;
    }

    private NodeAVL<E> adjustAfterDeleteLeft(NodeAVL<E> node) {
        switch (node.bf) {
            case 1 -> {
                NodeAVL<E> right = (NodeAVL<E>) node.right;
                switch (right.bf) {
                    case 0 -> {
                        node = rotateSL(node);
                        node.bf = -1;
                        ((NodeAVL<E>) node.left).bf = 1;
                        heightChanged = false;
                    }
                    case 1 -> {
                        node.bf = 0;
                        right.bf = 0;
                        node = rotateSL(node);
                        heightChanged = true;
                    }
                    case -1 -> {
                        NodeAVL<E> rl = (NodeAVL<E>) right.left;
                        switch (rl.bf) {
                            case 1 -> {
                                node.bf = -1;
                                right.bf = 0;
                            }
                            case 0 -> {
                                node.bf = 0;
                                right.bf = 0;
                            }
                            case -1 -> {
                                node.bf = 0;
                                right.bf = 1;
                            }
                        }
                        rl.bf = 0;
                        node.right = rotateSR(right);
                        node = rotateSL(node);
                        heightChanged = true;
                    }
                }
            }
            case 0 -> {
                node.bf = 1;
                heightChanged = false;
            }
            case -1 -> {
                node.bf = 0;
                heightChanged = true;
            }
        }
        return node;
    }

    private NodeAVL<E> adjustAfterDeleteRight(NodeAVL<E> node) {
        switch (node.bf) {
            case -1 -> {
                NodeAVL<E> left = (NodeAVL<E>) node.left;
                switch (left.bf) {
                    case 0 -> {
                        node = rotateSR(node);
                        node.bf = 1;
                        ((NodeAVL<E>) node.right).bf = -1;
                        heightChanged = false;
                    }
                    case -1 -> {
                        node.bf = 0;
                        left.bf = 0;
                        node = rotateSR(node);
                        heightChanged = true;
                    }
                    case 1 -> {
                        NodeAVL<E> lr = (NodeAVL<E>) left.right;
                        switch (lr.bf) {
                            case -1 -> {
                                node.bf = 1;
                                left.bf = 0;
                            }
                            case 0 -> {
                                node.bf = 0;
                                left.bf = 0;
                            }
                            case 1 -> {
                                node.bf = 0;
                                left.bf = -1;
                            }
                        }
                        lr.bf = 0;
                        node.left = rotateSL(left);
                        node = rotateSR(node);
                        heightChanged = true;
                    }
                }
            }
            case 0 -> {
                node.bf = -1;
                heightChanged = false;
            }
            case 1 -> {
                node.bf = 0;
                heightChanged = true;
            }
        }
        return node;
    }

    private NodeAVL<E> findMin(NodeAVL<E> node) {
        while (node.left != null) node = (NodeAVL<E>) node.left;
        return node;
    }

    // Rotaciones con logs de impresión

    private NodeAVL<E> rotateSL(NodeAVL<E> node) {
        System.out.println("Rotación simple a la izquierda en nodo " + node.data);
        NodeAVL<E> right = (NodeAVL<E>) node.right;

        System.out.println("Árbol antes de rotar:");
        printTree();

        node.right = right.left;
        right.left = node;

        System.out.println("Árbol después de rotar:");
        printTree();
        System.out.println("-------------------------");

        return right;
    }

    private NodeAVL<E> rotateSR(NodeAVL<E> node) {
        System.out.println("Rotación simple a la derecha en nodo " + node.data);
        NodeAVL<E> left = (NodeAVL<E>) node.left;

        System.out.println("Árbol antes de rotar:");
        printTree();

        node.left = left.right;
        left.right = node;

        System.out.println("Árbol después de rotar:");
        printTree();
        System.out.println("-------------------------");

        return left;
    }

    private NodeAVL<E> balanceLeft(NodeAVL<E> node) {
        NodeAVL<E> right = (NodeAVL<E>) node.right;
        if (right.bf == 1) {
            System.out.println("Balance Left - Rotación simple a la izquierda en nodo " + node.data);
            node.bf = right.bf = 0;
            return rotateSL(node);
        } else {
            System.out.println("Balance Left - Rotación doble izquierda en nodo " + node.data);
            NodeAVL<E> rl = (NodeAVL<E>) right.left;
            switch (rl.bf) {
                case -1 -> {
                    node.bf = 0;
                    right.bf = 1;
                }
                case 0 -> {
                    node.bf = 0;
                    right.bf = 0;
                }
                case 1 -> {
                    node.bf = -1;
                    right.bf = 0;
                }
            }
            rl.bf = 0;
            node.right = rotateSR(right);
            return rotateSL(node);
        }
    }

    private NodeAVL<E> balanceRight(NodeAVL<E> node) {
        NodeAVL<E> left = (NodeAVL<E>) node.left;
        if (left.bf == -1) {
            System.out.println("Balance Right - Rotación simple a la derecha en nodo " + node.data);
            node.bf = left.bf = 0;
            return rotateSR(node);
        } else {
            System.out.println("Balance Right - Rotación doble derecha en nodo " + node.data);
            NodeAVL<E> lr = (NodeAVL<E>) left.right;
            switch (lr.bf) {
                case 1 -> {
                    node.bf = 1;
                    left.bf = 0;
                }
                case 0 -> {
                    node.bf = 0;
                    left.bf = 0;
                }
                case -1 -> {
                    node.bf = 0;
                    left.bf = -1;
                }
            }
            lr.bf = 0;
            node.left = rotateSL(left);
            return rotateSR(node);
        }
    }

    // Métodos existentes para recorrido y impresión

    // Recorrido en anchura recursivo
    public void breadthFirstRecursive() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }
        Queue<Node<E>> queue = new LinkedQueue<>();
        queue.enqueue(root);
        breadthFirstRecursive(queue);
    }

    private void breadthFirstRecursive(Queue<Node<E>> queue) {
        if (queue.isEmpty()) return;
        Node<E> node = queue.dequeue();
        System.out.print(node.data + " ");
        if (node.left != null) queue.enqueue(node.left);
        if (node.right != null) queue.enqueue(node.right);
        breadthFirstRecursive(queue);
    }

    // Recorrido en preorden recursivo
    public void preOrder() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }
        preOrder((NodeAVL<E>) root);
    }

    private void preOrder(NodeAVL<E> node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder((NodeAVL<E>) node.left);
        preOrder((NodeAVL<E>) node.right);
    }

    // Impresión jerárquica del árbol
    public void printTree() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }
        printTree((NodeAVL<E>) root, 0);
    }

    private void printTree(NodeAVL<E> node, int level) {
        if (node == null) return;
        System.out.println("    ".repeat(level) + node.data + "(bf:" + node.bf + ")");
        printTree((NodeAVL<E>) node.left, level + 1);
        printTree((NodeAVL<E>) node.right, level + 1);
    }
}

