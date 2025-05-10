package ejercicio2;

import exceptions.ExceptionIsEmpty;

public class QueueArray<E> implements Queue<E> {
    private E[] data;
    private int first;
    private int last;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.data = (E[]) new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.size = 0;
    }

    public void enqueue(E x) {
        if (size == capacity) {
            System.out.println("Cola llena, no se puede insertar.");
            return;
        }
        data[last] = x;
        last = (last + 1) % capacity;
        size++;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("La cola está vacía.");
        E aux = data[first];
        data[first] = null;
        first = (first + 1) % capacity;
        size--;
        return aux;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("La cola está vacía.");
        return data[first];
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty())
            throw new ExceptionIsEmpty("La cola está vacía.");
        return data[(last - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += data[(first + i) % capacity];
            if (i != size - 1) result += ", ";
        }
        result += "]";
        return result;
    }
}
