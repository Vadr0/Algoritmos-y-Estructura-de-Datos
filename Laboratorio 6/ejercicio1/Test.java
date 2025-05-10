package ejercicio1;
import exceptions.ExceptionIsEmpty;


public class Test {
    public static void main(String[] args) {
        Stack<Integer> pilaEnteros = new StackLink<>();
        Stack<String> pilaCadenas = new StackLink<>();

        try {
            System.out.println("Probando pila de enteros...");
            pilaEnteros.push(10);
            pilaEnteros.push(20);
            pilaEnteros.push(30);
            System.out.println("Contenido: " + pilaEnteros);
            System.out.println("Tope: " + pilaEnteros.top());
            pilaEnteros.pop();
            System.out.println("Después de pop(): " + pilaEnteros);

            System.out.println("\nProbando pila de cadenas...");
            pilaCadenas.push("uno");
            pilaCadenas.push("dos");
            pilaCadenas.push("tres");
            System.out.println("Contenido: " + pilaCadenas);
            System.out.println("Tope: " + pilaCadenas.top());
            pilaCadenas.pop();
            System.out.println("Después de pop(): " + pilaCadenas);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
