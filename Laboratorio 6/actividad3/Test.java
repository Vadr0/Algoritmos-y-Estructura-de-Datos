package actividad3;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<String, Integer> pq = new PriorityQueueLinkSort<>();

        try {
            System.out.println("Probando cola de prioridad con strings:");
            pq.enqueue("tarea normal", 1);
            pq.enqueue("tarea urgente", 5);
            pq.enqueue("tarea media", 3);
            pq.enqueue("tarea crítica", 10);

            System.out.println("Contenido: " + pq);
            System.out.println("Frente (más prioridad): " + pq.front());
            System.out.println("Final (menos prioridad): " + pq.back());

            pq.dequeue();
            System.out.println("Después de quitar el frente: " + pq);
        } catch (ExceptionIsEmpty e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
