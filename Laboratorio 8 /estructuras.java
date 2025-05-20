package estructuras;

public class LinkedQueue<E> implements Queue<E> {
    private static class Node<E> {
        E data;
        Node<E> next;
        public Node(E data) { this.data = data; this.next = null; }
    }

    private Node<E> front, rear;

    public LinkedQueue() { front = rear = null; }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) throw new RuntimeException("Cola vacía");
        E data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    @Override
    public E front() {
        if (isEmpty()) throw new RuntimeException("Cola vacía");
        return front.data;
    }

    @Override
    public boolean isEmpty() { return front == null; }

    @Override
    public void clear() { front = rear = null; }
}
//////////////////////////////////////////////////////////////////////////////////////////
package estructuras;

public interface Queue<E> {
    void enqueue(E element);
    E dequeue();
    E front();
    boolean isEmpty();
    void clear();
}
