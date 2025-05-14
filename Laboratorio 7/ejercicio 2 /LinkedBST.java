import estructuras.LinkedQueue;
import estructuras.Queue;

import javax.swing.*;

import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

public class LinkedBST<E extends Comparable<E>> {
    private Node<E> root;

    private static class Node<E> {
        E data;
        Node<E> left, right;

        public Node(E data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // Constructor

    public LinkedBST() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString().trim();
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data).append(" ");
            inOrder(node.right, sb);
        }
    }

    // Ejercicio 2.a - area BST()
    public int areaBST() {
        if (root == null)
            return 0;
        Queue<Node<E>> queue = new LinkedQueue<>();
        queue.enqueue(root);

        int hojas = 0;
        int altura = -1;

        while (!queue.isEmpty()) {
            int size = getQueueSize(queue);
            altura++;
            for (int i = 0; i < size; i++) {
                Node<E> current = queue.dequeue();
                if (current.left == null && current.right == null)
                    hojas++;
                if (current.left != null)
                    queue.enqueue(current.left);
                if (current.right != null)
                    queue.enqueue(current.right);
            }
        }
        return hojas * altura;
    }

    private int getQueueSize(Queue<Node<E>> queue) {
        LinkedQueue<Node<E>> tempQueue = (LinkedQueue<Node<E>>) queue;
        int count = 0;
        Queue<Node<E>> aux = new LinkedQueue<>();
        while (!tempQueue.isEmpty()) {
            Node<E> node = tempQueue.dequeue();
            aux.enqueue(node);
            count++;
        }
        while (!aux.isEmpty()) {
            tempQueue.enqueue(aux.dequeue());
        }
        return count;
    }

    // Ejercicio 2.b - dibujamos el BST()
    public void drawBST() {
        JFrame frame = new JFrame("BST Dibujo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new BSTPanel());
        frame.setVisible(true);
    }

    private class BSTPanel extends JPanel {
        @Override
        protected void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);
            if (root != null)
                drawNode(g, root, getWidth() / 2, 50, getWidth() / 4);
        }

        private void drawNode(java.awt.Graphics g, Node<E> node, int x, int y, int xOffset) {
            g.drawOval(x - 15, y - 15, 30, 30);
            g.drawString(node.data.toString(), x - 7, y + 5);

            if (node.left != null) {
                g.drawLine(x, y, x - xOffset, y + 50);
                drawNode(g, node.left, x - xOffset, y + 50, xOffset / 2);
            }

            if (node.right != null) {
                g.drawLine(x, y, x + xOffset, y + 50);
                drawNode(g, node.right, x + xOffset, y + 50, xOffset / 2);
            }
        }
    }
}
