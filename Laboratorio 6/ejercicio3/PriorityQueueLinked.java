package ejercicio3;

import actividad2.*;
import actividad3.*;
import exceptions.ExceptionIsEmpty;

public class PriorityQueueLinked<E, N extends Number> implements PriorityQueue<E, N> {
    private Queue<E>[] queues;

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int levels) {
        queues = new Queue[levels];
        for (int i = 0; i < levels; i++) {
            queues[i] = new QueueLink<>();
        }
    }

    @Override
    public void enqueue(E data, N priority) {
        int p = priority.intValue();
        if (p < 0 || p >= queues.length) {
            throw new IllegalArgumentException("Prioridad fuera de rango");
        }
        queues[p].enqueue(data);
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (Queue<E> q : queues) {
            if (!q.isEmpty()) {
                return q.dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        for (Queue<E> q : queues) {
            if (!q.isEmpty()) {
                return q.front();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        for (int i = queues.length - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    @Override
    public boolean isEmpty() {
        for (Queue<E> q : queues) {
            if (!q.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < queues.length; i++) {
            result += "Prioridad " + i + ": " + queues[i].toString() + "\n";
        }
        return result;
    }

}
