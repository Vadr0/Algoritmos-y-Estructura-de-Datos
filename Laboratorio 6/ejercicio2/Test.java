package ejercicio2;

import estructuras.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        System.out.println("Probando cola de enteros...");
        Queue<Integer> colaEnteros = new QueueArray<>(5);
        colaEnteros.enqueue(1);
        colaEnteros.enqueue(2);
        colaEnteros.enqueue(3);
        System.out.println("Contenido: " + colaEnteros);
        System.out.println("Primero: " + colaEnteros.front());
        System.out.println("Último: " + colaEnteros.back());
        colaEnteros.dequeue();
        System.out.println("Después de dequeue(): " + colaEnteros);

        System.out.println("\nProbando cola de cadenas...");
        Queue<String> colaStrings = new QueueArray<>(5);
        colaStrings.enqueue("uno");
        colaStrings.enqueue("dos");
        colaStrings.enqueue("tres");
        System.out.println("Contenido: " + colaStrings);
        System.out.println("Primero: " + colaStrings.front());
        System.out.println("Último: " + colaStrings.back());
        colaStrings.dequeue();
        System.out.println("Después de dequeue(): " + colaStrings);
    }
}
