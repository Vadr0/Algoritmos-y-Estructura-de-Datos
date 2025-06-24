package Actividad2;

// Clase principal para probar la tabla hash cerrada con sondeo lineal
public class Main {
    public static void main(String[] args) {
        HashC tabla = new HashC(10); // Tamaño fijo de la tabla

        // Insertar registros
        tabla.insert(34, "Juan");
        tabla.insert(3, "Ana");
        tabla.insert(7, "Luis");
        tabla.insert(30, "Rosa");
        tabla.insert(11, "Pedro");
        tabla.insert(8, "Lucía");
        tabla.insert(7, "Mario");  // Colisión intencional
        tabla.insert(23, "Valeria");
        tabla.insert(41, "Daniel");
        tabla.insert(16, "Carla");
        tabla.insert(34, "Elena"); // Repetido

        System.out.println("\nTabla después de inserciones:");
        tabla.display();

        // Eliminar la clave 30
        tabla.delete(30);

        System.out.println("\nTabla después de eliminar clave 30:");
        tabla.display();

        // Buscar clave 23
        Register encontrado = tabla.search(23);
        if (encontrado != null) {
            System.out.println("\nSe encontró el registro con clave 23: " + encontrado);
        } else {
            System.out.println("\nNo se encontró la clave 23");
        }
    }
}
