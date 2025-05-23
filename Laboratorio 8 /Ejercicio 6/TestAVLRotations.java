public class TestAVLRotations {
    public static void main(String[] args) {
        AVLTreeWithRotationLogging<Integer> avlTree = new AVLTreeWithRotationLogging<>();
        try {
            System.out.println("Inserciones que provocan rotaciones:\n");
            avlTree.insert(10);
            avlTree.printTree();
            System.out.println();
            avlTree.insert(20);
            avlTree.printTree();
            System.out.println();
            avlTree.insert(30); 
            avlTree.printTree();
            System.out.println();
            avlTree.insert(25);
            avlTree.printTree();
            System.out.println();
            avlTree.insert(28); 
            avlTree.printTree();
            System.out.println();
            avlTree.insert(5);
            avlTree.printTree();
            System.out.println();
            avlTree.insert(4); 
            avlTree.printTree();
            System.out.println();
            avlTree.insert(3);
            avlTree.printTree();
            System.out.println();