package Actividad_1;

import bstreeInterface.BinarySearchTree;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import Node.Node;
import estructuras.LinkedQueue;
import estructuras.Queue;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
	//protected Node<E> root;
	public Node<E> root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        root = insertRec(root, data);
    }

    private Node<E> insertRec(Node<E> node, E data) throws ItemDuplicated {
        if (node == null) {
            return new Node<>(data);
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insertRec(node.left, data);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, data);
        } else {
            throw new ItemDuplicated("Elemento duplicado: " + data);
        }
        return node;
    }

    @Override
    public boolean search(E data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node<E> node, E data) {
        if (node == null) {
            return false;
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            return searchRec(node.left, data);
        } else if (cmp > 0) {
            return searchRec(node.right, data);
        } else {
            return true;
        }
    }

    @Override
    public void delete(E data) throws ItemNotFound, ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol está vacío");
        }
        root = deleteRec(root, data);
    }

    private Node<E> deleteRec(Node<E> node, E data) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("Elemento no encontrado: " + data);
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = deleteRec(node.left, data);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            
            node.data = minValue(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    private E minValue(Node<E> node) {
        E minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void destroy() {
        root = null;
    }

    @Override
    public String toString() {
        return inOrder(root).trim();
    }

    private String inOrder(Node<E> node) {
        if (node == null) return "";
        return inOrder(node.left) + node.data + " " + inOrder(node.right);
    }

    // Métodos adicionales
    public String preOrder() {
        return preOrder(root).trim();
    }

    private String preOrder(Node<E> node) {
        if (node == null) return "";
        return node.data + " " + preOrder(node.left) + preOrder(node.right);
    }

    public String postOrder() {
        return postOrder(root).trim();
    }

    private String postOrder(Node<E> node) {
        if (node == null) return "";
        return postOrder(node.left) + postOrder(node.right) + node.data + " ";
    }
}
