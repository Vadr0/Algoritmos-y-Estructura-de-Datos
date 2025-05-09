package actividad2;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x) {
        Node<E> newNode = new Node<>(x);
        if (this.isEmpty()) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }
        this.last = newNode;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        E data = this.first.getData();
        this.first = this.first.getNext();
        if (this.first == null) {
            this.last = null;
        }
        return data;
    }

    public E front() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return this.first.getData();
    }

    public E back() throws ExceptionIsEmpty {
        if (this.isEmpty()) {
            throw new ExceptionIsEmpty("La cola está vacía");
        }
        return this.last.getData();
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        String result = "[";
        Node<E> current = first;
        while (current != null) {
            result += current.getData();
            if (current.getNext() != null) result += ", ";
            current = current.getNext();
        }
        result += "]";
        return result;
    }
}
