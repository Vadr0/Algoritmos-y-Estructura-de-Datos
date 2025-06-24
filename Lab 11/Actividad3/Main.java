package Actividad3;

// Clase para probar la implementación de hash abierto
public class Main {
    public static void main(String[] args) {
        HashO tabla = new HashO(5); // tamaño fijo de la tabla

        // Insertar claves con colisiones intencionales (todos % 5 = 0)
        tabla.insert(10, "Juan");
        tabla.insert(15, "Ana");
        tabla.insert(20, "Luis");
        tabla.insert(25, "Rosa");
        tabla.insert(5, "Elena");  // misma posición que 10

        System.out.println("\nDespués de insertar:");
        tabla.display();

        // Buscar claves
        Register encontrado = tabla.search(20);
        if (encontrado != null) {
            System.out.println("\nSe encontró: " + encontrado);
        } else {
            System.out.println("\nNo se encontró la clave 20");
        }

        Register noExiste = tabla.search(30);
        if (noExiste != null) {
            System.out.println("\nSe encontró: " + noExiste);
        } else {
            System.out.println("\nNo se encontró la clave 30");
        }

        // Eliminar un elemento
        tabla.delete(15);
        System.out.println("\nDespués de eliminar la clave 15:");
        tabla.display();
    }
}
