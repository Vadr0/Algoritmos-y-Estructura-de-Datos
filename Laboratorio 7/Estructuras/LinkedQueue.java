package estructuras;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front, rear;

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {
        front = rear = null;
    }

    @Override
    public void enqueue(E element) {
        Node<E> node = new Node<>(element);
        if (isEmpty()) {
            front = rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new RuntimeException("Cola vacía");
        E data = front.data;
        front = front.next;
        if (front == null)
            rear = null;
        return data;
    }

    @Override
    public E front() {
        if (isEmpty())
            throw new RuntimeException("Cola vacía");
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public void clear() {
        front = rear = null;
    }
}
