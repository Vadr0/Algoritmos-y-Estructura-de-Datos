package ejercicio1;

import estructuras.LinkedList;
import exceptions.ExceptionIsEmpty;

public class StackLink<E> implements Stack<E> {
    private final LinkedList<E> list;

    public StackLink() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E x) {
        list.addAtStart(x);  // insertar al inicio
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        E data = list.getFirstNode().data;
        list.deleteNode(data);
        return data;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        return list.getFirstNode().data;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmptyList();
    }

    @Override
    public String toString() {
        String result = "[";
        var current = list.getFirstNode();
        while (current != null) {
            result += current.data;
            if (current.nextNode != null) {
                result += ", ";
            }
            current = current.nextNode;
        }
        result += "]";
        return result;
    }
}
