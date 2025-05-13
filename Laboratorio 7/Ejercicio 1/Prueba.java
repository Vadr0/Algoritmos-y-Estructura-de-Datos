import exceptions.ExceptionIsEmpty;

public class Prueba {
    public static void main(String[] args) {
        LinkedBST<Integer> arbol = new LinkedBST<>();

        // Insertamos algunos valores
        int[] datos = { 40, 20, 10, 30, 60, 50, 70 };
        for (int val : datos) {
            arbol.insert(val);
        }

        System.out.println("Recorrido InOrder:");
        System.out.println(arbol.toString()); // 10 20 30 40 50 60 70

        // A. countAllNodes()
        System.out.println("\n--- Probando countAllNodes() ---");
        System.out.println("Total de nodos (hojas y no hojas): " + arbol.countAllNodes()); // 7

        // B. countNodes()
        System.out.println("\n--- Probando countNodes() ---");
        System.out.println("Nodos NO hoja: " + arbol.countNodes()); // Esperado: 4 (nodos con hijos)

        // C. height(x)
        System.out.println("\n--- Probando height(x) ---");
        System.out.println("Altura del subárbol con raíz 20: " + arbol.height(20)); // Esperado: 1
        System.out.println("Altura del subárbol con raíz 60: " + arbol.height(60)); // Esperado: 1
        System.out.println("Altura del nodo inexistente (100): " + arbol.height(100)); // Esperado: -1

        // D. amplitude(nivel)
        System.out.println("\n--- Probando amplitude(nivel) ---");
        for (int nivel = 0; nivel <= 3; nivel++) {
            System.out.println("Nodos en el nivel " + nivel + ": " + arbol.amplitude(nivel));
        }

        // E. destroyNodes()
        System.out.println("\n--- Probando destroyNodes() ---");
        try {
            arbol.destroyNodes();
            System.out.println("Árbol destruido correctamente.");
        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción: " + e.getMessage());
        }

        System.out.println("¿Está vacío? " + (arbol.isEmpty() ? "Sí" : "No"));

        // Intentamos destruir otra vez para validar la excepción
        try {
            arbol.destroyNodes();
        } catch (ExceptionIsEmpty e) {
            System.out.println("Excepción al destruir de nuevo: " + e.getMessage());
        }
    }
}
