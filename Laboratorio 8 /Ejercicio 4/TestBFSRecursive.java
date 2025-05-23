public class TestBFSRecursive {
    public static void main(String[] args) {
        try {
            AVLTree<Integer> avl = new AVLTree<>();
            int[] values = {50, 30, 70, 40, 60, 80}; // Valores de la Figura 8.11

            for (int val : values) {
                avl.insert(val);
            }

            System.out.println("Recorrido por amplitud recursivo (BFS):");
            avl.breadthFirstRecursive(); // Debería imprimir: 50 30 70 40 60 80

        } catch (ItemDuplicated e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
