import bstreeInterface.BinarySearchTree;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

import estructuras.LinkedQueue;
import estructuras.Queue;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {
    private Node<E> root;

    public LinkedBST() {
        this.root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void destroy() {
        root = null;
    }

    public void destroyNodes() {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("El árbol ya está vacío.");
        }
        root = null;
    }

    @Override
    public void insert(E data) {
        root = insert(root, data);
    }

    private Node<E> insert(Node<E> node, E data) {
        if (node == null)
            return new Node<>(data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            node.left = insert(node.left, data);
        else if (cmp > 0)
            node.right = insert(node.right, data);
        else
            throw new ItemDuplicated("Dato duplicado: " + data);
        return node;
    }

    @Override
    public boolean search(E data) {
        return search(root, data);
    }

    private boolean search(Node<E> node, E data) {
        if (node == null)
            throw new ItemNotFound("Dato no encontrado: " + data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            return search(node.left, data);
        else if (cmp > 0)
            return search(node.right, data);
        else
            return true;
    }

    @Override
    public void delete(E data) {
        if (isEmpty())
            throw new ExceptionIsEmpty("El árbol está vacío.");
        root = delete(root, data);
    }

    private Node<E> delete(Node<E> node, E data) {
        if (node == null)
            throw new ItemNotFound("Dato no encontrado: " + data);
        int cmp = data.compareTo(node.data);
        if (cmp < 0)
            node.left = delete(node.left, data);
        else if (cmp > 0)
            node.right = delete(node.right, data);
        else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            Node<E> successor = findMin(node.right);
            node.data = successor.data;
            node.right = delete(node.right, successor.data);
        }
        return node;
    }

    private Node<E> findMin(Node<E> node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // InOrder: izquierda, raíz, derecha
    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }

    // PreOrder: raíz, izquierda, derecha
    private void preOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.data).append(" ");
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }

    public String preOrderString() {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString().trim();
    }

    // PostOrder: izquierda, derecha, raíz
    private void postOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(node.data).append(" ");
        }
    }

    public String postOrderString() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString().trim();
    }

    // EJERCICIO 1 - Métodos adicionales

    // a. Contar todos los nodos (hojas y no hojas)
    public int countAllNodes() {
        return countAllNodes(root);
    }

    private int countAllNodes(Node<E> node) {
        if (node == null)
            return 0;
        return 1 + countAllNodes(node.left) + countAllNodes(node.right);
    }

    // b. Contar solo nodos NO hoja
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node<E> node) {
        if (node == null || (node.left == null && node.right == null))
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // c. Altura iterativa del subárbol con raíz x
    public int height(E x) {
        Node<E> node = root;
        while (node != null) {
            int cmp = x.compareTo(node.data);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return heightIterative(node);
        }
        return -1; // No encontrado
    }

    private int heightIterative(Node<E> node) {
        if (node == null)
            return -1;
        Queue<Node<E>> queue = new LinkedQueue<>();
        queue.enqueue(node);
        int height = -1;

        while (!queue.isEmpty()) {
            int size = getQueueSize(queue);
            height++;
            for (int i = 0; i < size; i++) {
                Node<E> current = queue.dequeue();
                if (current.left != null)
                    queue.enqueue(current.left);
                if (current.right != null)
                    queue.enqueue(current.right);
            }
        }
        return height;
    }

   public String amplitude(int nivel) {
    if (nivel < 0) {
        return ""; // Nivel inválido
    }
    
    StringBuilder sb = new StringBuilder();
    Queue<Node<E>> queue = new LinkedQueue<>();
    
    if (root != null) {
        queue.enqueue(root);
    }
    
    int currentLevel = 0;
    boolean levelFound = false;
    
    while (!queue.isEmpty() && !levelFound) {
        int nodesInCurrentLevel = queue.size();
        
        if (currentLevel == nivel) {
            levelFound = true;
            // Agregar todos los nodos de este nivel al resultado
            for (int i = 0; i < nodesInCurrentLevel; i++) {
                Node<E> node = queue.dequeue();
                sb.append(node.data).append(" ");
            }
        } else {
            // Procesar el siguiente nivel
            for (int i = 0; i < nodesInCurrentLevel; i++) {
                Node<E> node = queue.dequeue();
                if (node.left != null) {
                    queue.enqueue(node.left);
                }
                if (node.right != null) {
                    queue.enqueue(node.right);
                }
            }
            currentLevel++;
        }
    }
    
    return sb.toString().trim();
}
}
}
