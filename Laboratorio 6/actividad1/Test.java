package actividad1;
import exceptions.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
        try {
            Stack<Integer> pilaEnteros = new StackArray<>(5);
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);

            System.out.println("Top: " + pilaEnteros.top());
            System.out.println("Pila: " + pilaEnteros);
            System.out.println("Pop: " + pilaEnteros.pop());
            System.out.println("Pila después de pop: " + pilaEnteros);

            Stack<String> pilaCadenas = new StackArray<>(3);
            pilaCadenas.push("Hola");
            pilaCadenas.push("Mundo");

            System.out.println("Top: " + pilaCadenas.top());
            System.out.println("Pila: " + pilaCadenas);
            System.out.println("Está vacía: " + pilaCadenas.isEmpty());

        } catch (ExceptionIsEmpty e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
