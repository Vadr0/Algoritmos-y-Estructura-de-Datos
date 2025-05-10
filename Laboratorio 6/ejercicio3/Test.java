package ejercicio3;
import actividad3.PriorityQueue;
import exceptions.ExceptionIsEmpty;


public class Test {
    public static void main(String[] args) {
        try {
            PriorityQueue<Integer, Integer> colaEnteros = new PriorityQueueLinked<>(3);
            colaEnteros.enqueue(10, 1);
            colaEnteros.enqueue(20, 2);
            colaEnteros.enqueue(30, 0);
            colaEnteros.enqueue(40, 1);

            System.out.println("Cola de enteros:");
            System.out.println(colaEnteros);

            System.out.println("Front: " + colaEnteros.front()); 
            System.out.println("Back: " + colaEnteros.back());   

            colaEnteros.dequeue(); 

            System.out.println("Después de un dequeue:");
            System.out.println(colaEnteros);

           
            PriorityQueue<String, Integer> colaCadenas = new PriorityQueueLinked<>(2);
            colaCadenas.enqueue("uno", 1);
            colaCadenas.enqueue("dos", 0);
            colaCadenas.enqueue("tres", 1);

            System.out.println("\nCola de cadenas:");
            System.out.println(colaCadenas);

            System.out.println("Front: " + colaCadenas.front()); 
            System.out.println("Back: " + colaCadenas.back());   

            colaCadenas.dequeue(); 

            System.out.println("Después de un dequeue:");
            System.out.println(colaCadenas);

        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepción: " + e.getMessage());
        }
    }
}