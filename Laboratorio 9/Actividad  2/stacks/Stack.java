package stacks;

import java.util.ArrayList;

public class Stack<E> {
    private ArrayList<E> data;

    public Stack() {
        data = new ArrayList<>();
    }

    public void push(E item) {
        data.add(item);
    }

    public E pop() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return data.remove(data.size() - 1);
    }

    public E peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }
}
