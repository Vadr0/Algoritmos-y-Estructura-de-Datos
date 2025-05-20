package Actividad_2;

import Node.Node;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;
import Actividad_1.LinkedBST;

package Actividad_2;

import Node.Node;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;
import Actividad_1.LinkedBST;

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
}
