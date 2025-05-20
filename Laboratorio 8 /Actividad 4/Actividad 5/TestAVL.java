public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        
        System.out.println("=== Casos de prueba para AVL ===");
        
        // Caso 1: Rotación Simple Derecha (RSD/LL)
        System.out.println("\nCaso 1: Rotación Simple Derecha (RSD/LL)");
        avl.insert(30);
        avl.insert(20);
        avl.insert(10);  // Provoca RSD
        System.out.println("Árbol después de inserción 30, 20, 10:");
        System.out.println(avl.toString());
        
        // Caso 2: Rotación Simple Izquierda (RSI/RR)
        System.out.println("\nCaso 2: Rotación Simple Izquierda (RSI/RR)");
        avl.insert(50);
        avl.insert(60);  // Provoca RSI
        System.out.println("Árbol después de inserción 50, 60:");
        System.out.println(avl.toString());
        
        // Caso 3: Rotación Doble Derecha (RDD/LR)
        System.out.println("\nCaso 3: Rotación Doble Derecha (RDD/LR)");
        avl.insert(15);  // Provoca RDD
        System.out.println("Árbol después de inserción 15:");
        System.out.println(avl.toString());
        
        // Caso 4: Rotación Doble Izquierda (RDI/RL)
        System.out.println("\nCaso 4: Rotación Doble Izquierda (RDI/RL)");
        avl.insert(55);  // Provoca RDI
        System.out.println("Árbol después de inserción 55:");
        System.out.println(avl.toString());
        
        // Caso 5: Secuencia que provoca múltiples rotaciones
        System.out.println("\nCaso 5: Secuencia compleja con múltiples rotaciones");
        avl.insert(5);
        avl.insert(3);
        avl.insert(8);
        avl.insert(7);
        avl.insert(9);
        avl.insert(12);  // Provocará varias rotaciones
        System.out.println("Árbol después de inserciones 5, 3, 8, 7, 9, 12:");
        System.out.println(avl.toString());
        
        // Caso 6: Rotación Simple Derecha en subárbol derecho
        System.out.println("\nCaso 6: RSD en subárbol derecho");
        avl.insert(65);
        avl.insert(70);
        avl.insert(68);  // Provoca RSD en subárbol derecho
        System.out.println("Árbol después de inserciones 65, 70, 68:");
        System.out.println(avl.toString());
        
        // Caso 7: Rotación Simple Izquierda en subárbol izquierdo
        System.out.println("\nCaso 7: RSI en subárbol izquierdo");
        avl.insert(1);
        avl.insert(2);
        avl.insert(4);  // Provoca RSI en subárbol izquierdo
        System.out.println("Árbol después de inserciones 1, 2, 4:");
        System.out.println(avl.toString());
        
        // Caso 8: Combinación compleja
        System.out.println("\nCaso 8: Combinación compleja");
        avl.insert(25);
        avl.insert(28);
        avl.insert(22);
        avl.insert(24);  // Provocará múltiples rotaciones
        System.out.println("Árbol después de inserciones 25, 28, 22, 24:");
        System.out.println(avl.toString());
    }
}
