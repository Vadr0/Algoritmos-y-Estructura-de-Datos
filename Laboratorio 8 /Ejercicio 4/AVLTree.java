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
        int height; // Altura del nodo

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
            this.height = 0; // Altura inicial
        }

        @Override
        public String toString() {
            return data + "(bf:" + bf + ", h:" + height + ")";
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
        } else { // Inserción por derecha
            node.right = insert(x, (NodeAVL<E>) node.right);
        }

        // Actualizar altura y balance factor
        updateHeightAndBalance(node);

        // Balancear si es necesario
        if (node.bf == -2) {
            if (((NodeAVL<E>) node.left).bf <= 0) {
                node = rotateSR(node); // Rotación simple derecha
            } else {
                node.left = rotateSL((NodeAVL<E>) node.left);
                node = rotateSR(node); // Rotación doble derecha
            }
        } else if (node.bf == 2) {
            if (((NodeAVL<E>) node.right).bf >= 0) {
                node = rotateSL(node); // Rotación simple izquierda
            } else {
                node.right = rotateSR((NodeAVL<E>) node.right);
                node = rotateSL(node); // Rotación doble izquierda
            }
        }

        return node;
    }

    private void updateHeightAndBalance(NodeAVL<E> node) {
        int leftHeight = (node.left == null) ? -1 : ((NodeAVL<E>) node.left).height;
        int rightHeight = (node.right == null) ? -1 : ((NodeAVL<E>) node.right).height;

        node.height = 1 + Math.max(leftHeight, rightHeight);
        node.bf = rightHeight - leftHeight;
    }

    private NodeAVL<E> rotateSL(NodeAVL<E> node) {
        NodeAVL<E> p = (NodeAVL<E>) node.right;
        node.right = p.left;
        p.left = node;

        // Actualizar alturas y balance factors
        updateHeightAndBalance(node);
        updateHeightAndBalance(p);

        return p;
    }

    private NodeAVL<E> rotateSR(NodeAVL<E> node) {
        NodeAVL<E> q = (NodeAVL<E>) node.left;
        node.left = q.right;
        q.right = node;

        // Actualizar alturas y balance factors
        updateHeightAndBalance(node);
        updateHeightAndBalance(q);

        return q;
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
        } else if (cmp > 0) {
            node.right = deleteAVL((NodeAVL<E>) node.right, x);
        } else {
            if (node.left == null) return (NodeAVL<E>) node.right;
            if (node.right == null) return (NodeAVL<E>) node.left;

            NodeAVL<E> successor = findMin((NodeAVL<E>) node.right);
            node.data = successor.data;
            node.right = deleteAVL((NodeAVL<E>) node.right, successor.data);
        }

        // Actualizar altura y balance factor
        updateHeightAndBalance(node);

        // Balancear si es necesario
        if (node.bf == -2) {
            if (((NodeAVL<E>) node.left).bf <= 0) {
                node = rotateSR(node);
            } else {
                node.left = rotateSL((NodeAVL<E>) node.left);
                node = rotateSR(node);
            }
        } else if (node.bf == 2) {
            if (((NodeAVL<E>) node.right).bf >= 0) {
                node = rotateSL(node);
            } else {
                node.right = rotateSR((NodeAVL<E>) node.right);
                node = rotateSL(node);
            }
        }

        return node;
    }

    private NodeAVL<E> findMin(NodeAVL<E> node) {
        while (node.left != null) {
            node = (NodeAVL<E>) node.left;
        }
        return node;
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

        String indent = "    ".repeat(level);
        System.out.println(indent + node.data + "(bf:" + node.bf + ", h:" + node.height + ")");

        if (node.left != null || node.right != null) {
            printTree((NodeAVL<E>) node.left, level + 1);
            printTree((NodeAVL<E>) node.right, level + 1);
        }
    }
}