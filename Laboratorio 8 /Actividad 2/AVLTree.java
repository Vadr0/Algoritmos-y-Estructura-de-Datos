package Actividad_2;

import Node.Node;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;
import Actividad_1.LinkedBST;

public class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {
    protected static class NodeAVL<E> extends Node<E> {
        protected int bf; // Factor de balance (-1, 0, 1)

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        @Override
        public String toString() {
            return super.data.toString() + "(bf: " + bf + ")";
        }
    }

    private boolean heightChanged; // Indicador de cambio de altura

    public AVLTree() {
        super();
        this.heightChanged = false;
    }

    @Override
    public void insert(E data) throws ItemDuplicated {
        this.root = insertAVL((NodeAVL<E>) this.root, data);
    }

    private NodeAVL<E> insertAVL(NodeAVL<E> node, E data) throws ItemDuplicated {
        if (node == null) {
            this.heightChanged = true;
            return new NodeAVL<>(data);
        }

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insertAVL((NodeAVL<E>) node.left, data);
            if (heightChanged) {
                switch (node.bf) {
                    case -1:
                        node.bf = 0;
                        heightChanged = false;
                        break;
                    case 0:
                        node.bf = 1;
                        break;
                    case 1:
                        node = balanceLeft(node);
                        heightChanged = false;
                        break;
                }
            }
        } else if (cmp > 0) {
            node.right = insertAVL((NodeAVL<E>) node.right, data);
            if (heightChanged) {
                switch (node.bf) {
                    case 1:
                        node.bf = 0;
                        heightChanged = false;
                        break;
                    case 0:
                        node.bf = -1;
                        break;
                    case -1:
                        node = balanceRight(node);
                        heightChanged = false;
                        break;
                }
            }
        } else {
            throw new ItemDuplicated("Elemento ya existe en el árbol AVL");
        }
        return node;
    }

    // Métodos de balanceo (rotaciones)
    private NodeAVL<E> balanceLeft(NodeAVL<E> node) {
        NodeAVL<E> leftChild = (NodeAVL<E>) node.left;
        if (leftChild.bf == 1) {
            return rotateLL(node);
        } else {
            return rotateLR(node);
        }
    }

    private NodeAVL<E> balanceRight(NodeAVL<E> node) {
        NodeAVL<E> rightChild = (NodeAVL<E>) node.right;
        if (rightChild.bf == -1) {
            return rotateRR(node);
        } else {
            return rotateRL(node);
        }
    }

    private NodeAVL<E> rotateLL(NodeAVL<E> node) {
        NodeAVL<E> leftChild = (NodeAVL<E>) node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        node.bf = 0;
        leftChild.bf = 0;
        return leftChild;
    }

    private NodeAVL<E> rotateRR(NodeAVL<E> node) {
        NodeAVL<E> rightChild = (NodeAVL<E>) node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        node.bf = 0;
        rightChild.bf = 0;
        return rightChild;
    }

    private NodeAVL<E> rotateLR(NodeAVL<E> node) {
        NodeAVL<E> leftChild = (NodeAVL<E>) node.left;
        NodeAVL<E> rightGrandchild = (NodeAVL<E>) leftChild.right;
        
        leftChild.right = rightGrandchild.left;
        rightGrandchild.left = leftChild;
        node.left = rightGrandchild.right;
        rightGrandchild.right = node;
        
        // Actualización de factores de balance
        if (rightGrandchild.bf == 1) {
            node.bf = -1;
            leftChild.bf = 0;
        } else if (rightGrandchild.bf == -1) {
            node.bf = 0;
            leftChild.bf = 1;
        } else {
            node.bf = 0;
            leftChild.bf = 0;
        }
        rightGrandchild.bf = 0;
        return rightGrandchild;
    }

    private NodeAVL<E> rotateRL(NodeAVL<E> node) {
        NodeAVL<E> rightChild = (NodeAVL<E>) node.right;
        NodeAVL<E> leftGrandchild = (NodeAVL<E>) rightChild.left;
        
        rightChild.left = leftGrandchild.right;
        leftGrandchild.right = rightChild;
        node.right = leftGrandchild.left;
        leftGrandchild.left = node;
        
        // Actualización de factores de balance
        if (leftGrandchild.bf == -1) {
            node.bf = 1;
            rightChild.bf = 0;
        } else if (leftGrandchild.bf == 1) {
            node.bf = 0;
            rightChild.bf = -1;
        } else {
            node.bf = 0;
            rightChild.bf = 0;
        }
        leftGrandchild.bf = 0;
        return leftGrandchild;
    }

    @Override
    public String toString() {
        return inOrderAVL((NodeAVL<E>) this.root).trim();
    }

    private String inOrderAVL(NodeAVL<E> node) {
        if (node == null) return "";
        return inOrderAVL((NodeAVL<E>) node.left) + node.toString() + " " + inOrderAVL((NodeAVL<E>) node.right);
    }
}
