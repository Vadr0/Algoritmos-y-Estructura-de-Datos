package Ejercicio_4;

import Node.Node;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;
import Actividad_1.LinkedBST;
import estructuras.LinkedQueue;
import estructuras.Queue;
public class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {
    protected static class NodeAVL<E> extends Node<E> {
        int bf; // Factor de balance: -1, 0, 1

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        @Override
        public String toString() {
            return data + "(bf:" + bf + ")";
        }
    }

    private boolean height; // Indicador de cambio de altura

    @Override
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL<E>) this.root);
    }

    protected NodeAVL<E> insert(E x, NodeAVL<E> node) throws ItemDuplicated {
        if (node == null) {
            this.height = true;
            return new NodeAVL<>(x);
        }

        int resC = x.compareTo(node.data);
        if (resC == 0) {
            throw new ItemDuplicated(x + " ya se encuentra en el árbol");
        }

        if (resC < 0) { // Inserción por izquierda
            node.left = insert(x, (NodeAVL<E>) node.left);
            if (this.height) {
                switch (node.bf) {
                    case 1:
                        node.bf = 0;
                        this.height = false;
                        break;
                    case 0:
                        node.bf = -1;
                        this.height = true;
                        break;
                    case -1: // bf = -2 (necesita balanceo)
                        node = balanceToRight(node);
                        this.height = false;
                        break;
                }
            }
        } else { // Inserción por derecha (completar simétricamente)
            node.right = insert(x, (NodeAVL<E>) node.right);
            if (this.height) {
                switch (node.bf) {
                    case -1:
                        node.bf = 0;
                        this.height = false;
                        break;
                    case 0:
                        node.bf = 1;
                        this.height = true;
                        break;
                    case 1: // bf = 2 (necesita balanceo)
                        node = balanceToLeft(node);
                        this.height = false;
                        break;
                }
            }
        }
        return node;
    }

    // Rotación Simple a Izquierda (RSL)
    private NodeAVL<E> rotateSL(NodeAVL<E> node) {
        NodeAVL<E> p = (NodeAVL<E>) node.right;
        node.right = p.left;
        p.left = node;
        return p;
    }

    // Rotación Simple a Derecha (RSR) - Simétrica a RSL
    private NodeAVL<E> rotateSR(NodeAVL<E> node) {
        NodeAVL<E> q = (NodeAVL<E>) node.left;
        node.left = q.right;
        q.right = node;
        return q;
    }

    // Balanceo hacia izquierda (para bf = +2)
    private NodeAVL<E> balanceToLeft(NodeAVL<E> node) {
        NodeAVL<E> hijo = (NodeAVL<E>) node.right;
        switch (hijo.bf) {
            case 1: // Caso LL
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
                break;
            case -1: // Caso LR
                NodeAVL<E> nieto = (NodeAVL<E>) hijo.left;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = -1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.right = rotateSR(hijo);
                node = rotateSL(node);
        }
        return node;
    }

    // Balanceo hacia derecha (simétrico a balanceToLeft)
    private NodeAVL<E> balanceToRight(NodeAVL<E> node) {
        NodeAVL<E> hijo = (NodeAVL<E>) node.left;
        switch (hijo.bf) {
            case -1: // Caso RR
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1: // Caso RL
                NodeAVL<E> nieto = (NodeAVL<E>) hijo.right;
                switch (nieto.bf) {
                    case 1:
                        node.bf = 0;
                        hijo.bf = -1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case -1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
        }
        return node;
    }
    
    @Override
    public void delete(E x) throws ItemNotFound, ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol está vacío");
        }
        this.root = deleteAVL((NodeAVL<E>) this.root, x);
    }

    private NodeAVL<E> deleteAVL(NodeAVL<E> node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound(x + " no encontrado en el árbol");
        }

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteAVL((NodeAVL<E>) node.left, x);
            // Actualizar bf y balancear después de eliminar en subárbol izquierdo
            node = updateBalanceLeft(node);
        } else if (cmp > 0) {
            node.right = deleteAVL((NodeAVL<E>) node.right, x);
            // Actualizar bf y balancear después de eliminar en subárbol derecho
            node = updateBalanceRight(node);
        } else {
            // Caso 1: Nodo hoja o con un solo hijo
            if (node.left == null) return (NodeAVL<E>) node.right;
            if (node.right == null) return (NodeAVL<E>) node.left;

            // Caso 2: Nodo con dos hijos
            NodeAVL<E> successor = findMin((NodeAVL<E>) node.right);
            node.data = successor.data;
            node.right = deleteAVL((NodeAVL<E>) node.right, successor.data);
            node = updateBalanceRight(node);
        }
        return node;
    }
    
    private NodeAVL<E> updateBalanceLeft(NodeAVL<E> node) {
        node.bf = getHeight((NodeAVL<E>) node.left) - getHeight((NodeAVL<E>) node.right);
        if (node.bf == 2) { // Desbalance hacia la izquierda
            return balanceToRight(node);
        }
        return node;
    }

    private NodeAVL<E> updateBalanceRight(NodeAVL<E> node) {
        node.bf = getHeight((NodeAVL<E>) node.left) - getHeight((NodeAVL<E>) node.right);
        if (node.bf == -2) { // Desbalance hacia la derecha
            return balanceToLeft(node);
        }
        return node;
    }

    private NodeAVL<E> findMin(NodeAVL<E> node) {
        while (node.left != null) {
            node = (NodeAVL<E>) node.left;
        }
        return node;
    }

    private int getHeight(NodeAVL<E> node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeight((NodeAVL<E>) node.left), getHeight((NodeAVL<E>) node.right));
    }
    
    public void breadthFirstRecursive() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }

        Queue<Node<E>> queue = new LinkedQueue<>();
        queue.enqueue(root);
        breadthFirstRecursive(queue);
    }

    // Método privado recursivo
    private void breadthFirstRecursive(Queue<Node<E>> queue) {
        if (queue.isEmpty()) {
            return; // Caso base: cola vacía
        }

        Node<E> current = queue.dequeue();
        System.out.print(current.data + " "); // Procesar el nodo actual

        // Encolar hijos izquierdo y derecho
        if (current.left != null) {
            queue.enqueue(current.left);
        }
        if (current.right != null) {
            queue.enqueue(current.right);
        }

        // Llamada recursiva para el siguiente nivel
        breadthFirstRecursive(queue);
    }
    
    public void printTree() {
        if (root == null) {
            System.out.println("Árbol vacío");
            return;
        }
        printTree((NodeAVL<E>) root, 0);
    }

    private void printTree(NodeAVL<E> node, int level) {
        if (node == null) return;

        // Espacios para la indentación según el nivel
        String indent = "    ".repeat(level);

        // Imprimir el nodo actual
        System.out.println(indent + node.data + "(bf:" + node.bf + ")");

        // Imprimir hijos izquierdo y derecho
        if (node.left != null || node.right != null) {
            printTree((NodeAVL<E>) node.left, level + 1);
            printTree((NodeAVL<E>) node.right, level + 1);
        }
    }
}
