package queues;

public class Queue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> front, rear;
    private int size = 0;

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (rear != null) {
            rear.next = node;
        }
        rear = node;
        if (front == null) {
            front = rear;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        T data = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }
}