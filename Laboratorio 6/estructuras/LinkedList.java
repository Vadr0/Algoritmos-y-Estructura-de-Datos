package estructuras;

public class LinkedList<T> {
    private Node<T> firstNode;

    public LinkedList() {
        firstNode = null;
    }

    public void setFirstNode(Node<T> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<T> getFirstNode() {
        return firstNode;
    }

    public boolean isEmptyList() {
        return firstNode == null;
    }

    public int listSize() {
        int count = 0;
        Node<T> currentNode = firstNode;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.nextNode;
        }
        return count;
    }

    public void destroyList() {
        firstNode = null;
    }

    public int search(T elementToSearch) {
        int position = 0;
        Node<T> currentNode = firstNode;

        while (currentNode != null) {
            if (currentNode.data.equals(elementToSearch)) {
                return position;
            }
            currentNode = currentNode.nextNode;
            position++;
        }
        return -1;
    }

    public void addAtStart(T data) {
        Node<T> newNode = new Node<>(data);

        if (firstNode == null) {
            firstNode = newNode;
        } else {
            newNode.nextNode = firstNode;
            firstNode = newNode;
        }
    }

    public void addAtEnd(T data) {
        Node<T> newNode = new Node<>(data);

        if (firstNode == null) {
            firstNode = newNode;
        } else {
            Node<T> currentNode = firstNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
    }

    public void deleteNode(T data) {
        if (firstNode == null) {
            System.out.println("Lista vacia.");
            return;
        }

        if (firstNode.data.equals(data)) {
            firstNode = firstNode.nextNode;
            return;
        }

        Node<T> currentNode = firstNode;
        while (currentNode.nextNode != null) {
            if (currentNode.nextNode.data.equals(data)) {
                currentNode.nextNode = currentNode.nextNode.nextNode;
                return;
            }
            currentNode = currentNode.nextNode;
        }
        System.out.println("No se encontro el elemento");
    }

    public void printList() {
        if (firstNode == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.nextNode;
        }
        System.out.println("null");
    }
}
