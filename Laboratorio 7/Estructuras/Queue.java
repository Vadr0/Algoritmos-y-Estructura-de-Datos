package estructuras;

public interface Queue<E> {
    void enqueue(E element);

    E dequeue();

    E front();

    boolean isEmpty();

    void clear();
}
