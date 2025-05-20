public class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {
    private boolean heightChanged;
    
    public AVLTree() {
        super();
        heightChanged = false;
    }
    
    @Override
    public void insert(E data) {
        root = insert((NodeAVL<E>) root, data);
    }
    
    private NodeAVL<E> insert(NodeAVL<E> node, E data) {
        if (node == null) {
            heightChanged = true;
            return new NodeAVL<>(data);
        }
        
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert((NodeAVL<E>) node.left, data);
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
            node.right = insert((NodeAVL<E>) node.right, data);
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
            throw new ItemDuplicated("Dato duplicado: " + data);
        }
        
        // Actualizar altura del nodo
        updateHeight(node);
        return node;
    }
    
    @Override
    public void delete(E data) {
        if (isEmpty())
            throw new ExceptionIsEmpty("El árbol está vacío.");
        root = delete((NodeAVL<E>) root, data);
    }
    
    private NodeAVL<E> delete(NodeAVL<E> node, E data) {
        if (node == null)
            throw new ItemNotFound("Dato no encontrado: " + data);
        
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete((NodeAVL<E>) node.left, data);
            if (heightChanged) {
                node = rebalanceRight(node);
            }
        } else if (cmp > 0) {
            node.right = delete((NodeAVL<E>) node.right, data);
            if (heightChanged) {
                node = rebalanceLeft(node);
            }
        } else {
            // Nodo encontrado
            if (node.left == null || node.right == null) {
                heightChanged = true;
                node = (NodeAVL<E>) (node.left != null ? node.left : node.right);
            } else {
                NodeAVL<E> successor = (NodeAVL<E>) findMin(node.right);
                node.data = successor.data;
                node.right = delete((NodeAVL<E>) node.right, successor.data);
                if (heightChanged) {
                    node = rebalanceLeft(node);
                }
            }
        }
        
        if (node != null) {
            updateHeight(node);
        }
        return node;
    }
    
    // Métodos de balanceo
    private NodeAVL<E> balanceLeft(NodeAVL<E> node) {
        NodeAVL<E> leftChild = (NodeAVL<E>) node.left;
        
        if (leftChild.bf == 1) {
            // Rotación simple a derecha
            return rotateRight(node);
        } else {
            // Rotación doble izquierda-derecha
            node.left = rotateLeft(leftChild);
            return rotateRight(node);
        }
    }
    
    private NodeAVL<E> balanceRight(NodeAVL<E> node) {
        NodeAVL<E> rightChild = (NodeAVL<E>) node.right;
        
        if (rightChild.bf == -1) {
            // Rotación simple a izquierda
            return rotateLeft(node);
        } else {
            // Rotación doble derecha-izquierda
            node.right = rotateRight(rightChild);
            return rotateLeft(node);
        }
    }
    
    // Rotación simple a la derecha
    private NodeAVL<E> rotateRight(NodeAVL<E> node) {
        NodeAVL<E> leftChild = (NodeAVL<E>) node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        
        // Actualizar alturas y factores de equilibrio
        updateHeight(node);
        updateHeight(leftChild);
        
        return leftChild;
    }
    
    // Rotación simple a la izquierda
    private NodeAVL<E> rotateLeft(NodeAVL<E> node) {
        NodeAVL<E> rightChild = (NodeAVL<E>) node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        
        // Actualizar alturas y factores de equilibrio
        updateHeight(node);
        updateHeight(rightChild);
        
        return rightChild;
    }
    
    private NodeAVL<E> rebalanceRight(NodeAVL<E> node) {
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
        updateHeight(node);
        return node;
    }
    
    private NodeAVL<E> rebalanceLeft(NodeAVL<E> node) {
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
        updateHeight(node);
        return node;
    }
    
    // Métodos auxiliares
    private void updateHeight(NodeAVL<E> node) {
        int leftHeight = getHeight((NodeAVL<E>) node.left);
        int rightHeight = getHeight((NodeAVL<E>) node.right);
        node.height = 1 + Math.max(leftHeight, rightHeight);
        node.bf = leftHeight - rightHeight;
    }
    
    private int getHeight(NodeAVL<E> node) {
        return node == null ? 0 : node.height;
    }
    
    // Sobrescribir findMin para devolver NodeAVL
    @Override
    protected NodeAVL<E> findMin(Node<E> node) {
        while (node.left != null)
            node = node.left;
        return (NodeAVL<E>) node;
    }
    
    public void insert(E x) throws ItemDuplicated {
    this.height = false;
    this.root = insert(x, (NodeAVL)this.root);
}

protected Node insert(E x, NodeAVL node) throws ItemDuplicated {
    NodeAVL fat = node;

    if (node == null) {
        this.height = true;
        fat = new NodeAVL(x);
    }
    else {
        int resC = node.data.compareTo(x);
        if(resC == 0) {
            throw new ItemDuplicated(x + " ya se encuentra en el arbol");
        }
        if(resC < 0) {
            fat.right = insert(x, (NodeAVL)node.right);
            if(this.height) {
                switch(fat.bf) {
                    case -1: 
                        fat.bf = 0;
                        this.height = false;
                        break;
                    case 0:
                        fat.bf = -1;
                        this.height = true;
                        break;
                    case 1: // bf = 2
                        fat = balanceToRight(fat);
                        this.height = false;
                        break;
                }
            }
        }
        else {
            // Inserción por la izquierda (completar esta parte)
            fat.left = insert(x, (NodeAVL)node.left);
            if(this.height) {
                switch(fat.bf) {
                    case 1:
                        fat.bf = 0;
                        this.height = false;
                        break;
                    case 0:
                        fat.bf = 1;
                        this.height = true;
                        break;
                    case -1: // bf = -2
                        fat = balanceToLeft(fat);
                        this.height = false;
                        break;
                }
            }
        }
    }
    return fat;
}
}
