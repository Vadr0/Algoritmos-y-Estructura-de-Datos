package Lab8;

public class PruebaAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();

        int[] claves = {30, 15, 20, 50, 40, 60, 70, 10, 25, 45, 55, 65, 75};

        for (int clave : claves) {
            System.out.println("\nInsertando: " + clave);
            avl.insert(clave);
            avl.printPreOrder();
        }
    }
}
