package Ejercicio2;

public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        // Mínimo 8 inserciones que provoquen todas las rotaciones
        int[] datos = {30, 15, 20, 50, 40, 60, 10, 5, 55, 70};

        for (int dato : datos) {
            System.out.println("\nInsertando: " + dato);
            avl.insert(dato);
            avl.printPreOrder();
        }
    }
}
