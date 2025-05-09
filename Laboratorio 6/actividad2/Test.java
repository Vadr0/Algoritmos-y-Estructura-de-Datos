package actividad2;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> intQueue = new QueueLink<>();
        Queue<String> stringQueue = new QueueLink<>();

        try {
            System.out.println("Probando cola de enteros...");
            intQueue.enqueue(5);
            intQueue.enqueue(15);
            intQueue.enqueue(25);
            intQueue.enqueue(35);
            System.out.println("Contenido: " + intQueue);
            System.out.println("Frente: " + intQueue.front());
            System.out.println("Final: " + intQueue.back());
            intQueue.dequeue();
            System.out.println("Después de quitar uno: " + intQueue);

            System.out.println("\nProbando cola de strings...");
            stringQueue.enqueue("manzana");
            stringQueue.enqueue("plátano");
            stringQueue.enqueue("cereza");
            stringQueue.enqueue("uva");
            System.out.println("Contenido: " + stringQueue);
            System.out.println("Frente: " + stringQueue.front());
            System.out.println("Final: " + stringQueue.back());
            stringQueue.dequeue();
            System.out.println("Después de quitar uno: " + stringQueue);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
