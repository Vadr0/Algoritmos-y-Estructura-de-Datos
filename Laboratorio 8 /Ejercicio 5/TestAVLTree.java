public class TestAVLTree {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();

        try {
            avlTree.insert(30);
            avlTree.insert(20);
            avlTree.insert(40);
            avlTree.insert(10);
            avlTree.insert(25);
            avlTree.insert(35);
            avlTree.insert(50);

            System.out.println("Recorrido en preorden:");
            avlTree.preOrder();
            System.out.println("\n");

            System.out.println("Recorrido en anchura (recursivo):");
            avlTree.breadthFirstRecursive();
            System.out.println("\n");

            System.out.println("Impresión jerárquica del árbol:");
            avlTree.printTree();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
