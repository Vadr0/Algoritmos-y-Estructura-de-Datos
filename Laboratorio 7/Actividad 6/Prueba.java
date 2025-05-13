import bstreelinklistinterfgeneric.LinkedBST;
import exceptions.ExceptionIsEmpty;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;

public class Prueba {
    public static void main(String[] args) {
        LinkedBST<Integer> arbol = new LinkedBST<>();

        System.out.println("== PRUEBAS DE LA ACTIVIDAD 6 ==");

        try {
            System.out.println("\nInsertando elementos en el árbol:");
            int[] valores = {15, 10, 20, 8, 12, 17, 25};
            for (int val : valores) {
                System.out.print("Insertando " + val + "...\n");
                arbol.insert(val);
            }

            System.out.println("\nRecorrido InOrder del árbol:");
            System.out.println(arbol.toString());  // debe mostrar los números en orden ascendente

            System.out.println("\nBuscando el número 12:");
            boolean encontrado = arbol.search(12);
            System.out.println("¿Encontrado? " + (encontrado ? "Sí" : "No"));

            System.out.println("\nEliminando el número 10 (tiene 2 hijos):");
            arbol.delete(10);
            System.out.println("Recorrido actualizado:");
            System.out.println(arbol.toString());

            System.out.println("\nEliminando el número 8 (nodo hoja):");
            arbol.delete(8);
            System.out.println("Recorrido actualizado:");
            System.out.println(arbol.toString());

            System.out.println("\nEliminando el número 17 (nodo con un hijo):");
            arbol.delete(17);
            System.out.println("Recorrido actualizado:");
            System.out.println(arbol.toString());

            System.out.println("\nBuscando el número 100 (no existe):");
            arbol.search(100); // lanza excepción

        } catch (ItemDuplicated e) {
            System.err.println("Excepción: " + e.getMessage());
        } catch (ItemNotFound e) {
            System.err.println("Excepción: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepción: " + e.getMessage());
        }

        try {
            System.out.println("\nDestruyendo árbol...");
            arbol.destroy();
            System.out.println("¿Está vacío? " + (arbol.isEmpty() ? "Sí" : "No"));

            System.out.println("\nIntentando eliminar en árbol vacío:");
            arbol.delete(15);  // lanza ExceptionIsEmpty
        } catch (ExceptionIsEmpty e) {
            System.err.println("Excepción: " + e.getMessage());
        }
    }
}
