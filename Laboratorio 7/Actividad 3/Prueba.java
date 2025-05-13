import bstreelinklistinterfgeneric.LinkedBST;
import exceptions.ItemDuplicated;
import exceptions.ItemNotFound;
import exceptions.ExceptionIsEmpty;

public class Prueba {
    public static void main(String[] args) {
        LinkedBST<Integer> arbol = new LinkedBST<>();

        try {
            System.out.println("Insertando elementos...");
            arbol.insert(8);
            arbol.insert(3);
            arbol.insert(10);
            arbol.insert(1);
            arbol.insert(6);
            arbol.insert(14);
            arbol.insert(4);
            arbol.insert(7);
            arbol.insert(13);

            System.out.println("Recorrido InOrder del árbol:");
            System.out.println(arbol.toString());

            System.out.println("Buscando el número 6:");
            System.out.println(arbol.search(6) ? "Encontrado" : "No encontrado");

            System.out.println("Eliminando el número 10:");
            arbol.delete(10);
            System.out.println("Nuevo recorrido InOrder:");
            System.out.println(arbol.toString());

            System.out.println("Eliminando el número 100 (no existe):");
            arbol.delete(100);  // Provocará ItemNotFound

        } catch (ItemDuplicated e) {
            System.err.println("Error: " + e.getMessage());
        } catch (ItemNotFound e) {
            System.err.println("Error: " + e.getMessage());
        } catch (ExceptionIsEmpty e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("Destruyendo árbol...");
        arbol.destroy();
        System.out.println("¿Está vacío? " + arbol.isEmpty());
    }
}
