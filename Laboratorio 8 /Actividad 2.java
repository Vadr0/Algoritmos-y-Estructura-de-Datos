public class AVLTree<E extends Comparable<E>> extends BSTree<E> {
    protected class NodeAVL extends Node {
        protected int bf; // Balance factor (-1, 0, 1)
        
        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }
        
        @Override
        public String toString() {
            return super.toString() + "(bf:" + bf + ")";
        }
    }
    
    private boolean heightChanged;
    
    public AVLTree() {
        super();
        heightChanged = false;
    }
    
    // Método para insertar un elemento
    @Override
    public void insert(E x) throws ItemDuplicated {
        root = insert(x, (NodeAVL) root);
    }
    
    private NodeAVL insert(E x, NodeAVL node) throws ItemDuplicated {
        if (node == null) {
            heightChanged = true;
            return new NodeAVL(x);
        }
        
        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(x, (NodeAVL) node.left);
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
            node.right = insert(x, (NodeAVL) node.right);
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
            throw new ItemDuplicated("El elemento ya existe en el árbol");
        }
        return node;
    }
    
    // Métodos de balanceo
    private NodeAVL balanceLeft(NodeAVL node) {
        NodeAVL leftChild = (NodeAVL) node.left;
        
        if (leftChild.bf == 1) {
            // Rotación simple a derecha
            node = rotateRight(node);
        } else {
            // Rotación doble izquierda-derecha
            node.left = rotateLeft(leftChild);
            node = rotateRight(node);
        }
        return node;
    }
    
    private NodeAVL balanceRight(NodeAVL node) {
        NodeAVL rightChild = (NodeAVL) node.right;
        
        if (rightChild.bf == -1) {
            // Rotación simple a izquierda
            node = rotateLeft(node);
        } else {
            // Rotación doble derecha-izquierda
            node.right = rotateRight(rightChild);
            node = rotateLeft(node);
        }
        return node;
    }
    
    // Rotación simple a la derecha
    private NodeAVL rotateRight(NodeAVL node) {
        NodeAVL leftChild = (NodeAVL) node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        
        // Actualizar factores de equilibrio
        node.bf = 0;
        leftChild.bf = 0;
        
        return leftChild;
    }
    
    // Rotación simple a la izquierda
    private NodeAVL rotateLeft(NodeAVL node) {
        NodeAVL rightChild = (NodeAVL) node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        
        // Actualizar factores de equilibrio
        node.bf = 0;
        rightChild.bf = 0;
        
        return rightChild;
    }
    
    // Método para eliminar un elemento
    @Override
    public void remove(E x) throws ItemNotFound {
        root = remove(x, (NodeAVL) root);
    }
    
    private NodeAVL remove(E x, NodeAVL node) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("El elemento no está en el árbol");
        }
        
        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = remove(x, (NodeAVL) node.left);
            if (heightChanged) {
                node = rebalanceRight(node);
            }
        } else if (cmp > 0) {
            node.right = remove(x, (NodeAVL) node.right);
            if (heightChanged) {
                node = rebalanceLeft(node);
            }
        } else {
            // Nodo encontrado
            if (node.left == null || node.right == null) {
                heightChanged = true;
                node = (NodeAVL) (node.left != null ? node.left : node.right);
            } else {
                NodeAVL successor = (NodeAVL) getSuccessor(node);
                node.data = successor.data;
                node.right = remove(successor.data, (NodeAVL) node.right);
                if (heightChanged) {
                    node = rebalanceLeft(node);
                }
            }
        }
        return node;
    }
    
    private NodeAVL rebalanceRight(NodeAVL node) {
        switch (node.bf) {
            case 1:
                node.bf = 0;
                break;
            case 0:
                node.bf = -1;
                heightChanged = false;
                break;
            case -1:
                node = balanceRight(node);
                if (node.bf != 0) {
                    heightChanged = false;
                }
                break;
        }
        return node;
    }
    
    private NodeAVL rebalanceLeft(NodeAVL node) {
        switch (node.bf) {
            case -1:
                node.bf = 0;
                break;
            case 0:
                node.bf = 1;
                heightChanged = false;
                break;
            case 1:
                node = balanceLeft(node);
                if (node.bf != 0) {
                    heightChanged = false;
                }
                break;
        }
        return node;
    }
    
    private Node getSuccessor(Node node) {
        Node current = node.right;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    // Método para buscar un elemento
    @Override
    public E search(E x) throws ItemNotFound {
        NodeAVL node = (NodeAVL) search(x, root);
        if (node == null) {
            throw new ItemNotFound("Elemento no encontrado");
        }
        return node.data;
    }
    
    private Node search(E x, Node node) {
        if (node == null) {
            return null;
        }
        
        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            return search(x, node.left);
        } else if (cmp > 0) {
            return search(x, node.right);
        } else {
            return node;
        }
    }
}

////////////////////////////////////////
// ItemDuplicated.java
public class ItemDuplicated extends Exception {
    public ItemDuplicated(String message) {
        super(message);
    }
}

// ItemNotFound.java
public class ItemNotFound extends Exception {
    public ItemNotFound(String message) {
        super(message);
    }
}
