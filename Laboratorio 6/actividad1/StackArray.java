package actividad1;

public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;

    @SuppressWarnings("unchecked")
    public StackArray(int n) {
        this.array = (E[]) new Object[n];
        this.tope = -1;
    }

    public void push(E x) {
        if (isFull()) {
            throw new RuntimeException("Pila llena");
        }
        array[++tope] = x;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Pila vacía");
        }
        return array[tope--];
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Pila vacía");
        }
        return array[tope];
    }

    public boolean isEmpty() {
        return this.tope == -1;
    }

    public boolean isFull() {
        return this.tope == array.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]);
            if (i != 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
