import bstreelinklistinterfgeneric.LinkedBST;

public class PruebaInOrder {
    public static void main(String[] args) {
        LinkedBST<Integer> arbol = new LinkedBST<>();

        int[] datos = {40, 20, 10, 30, 60, 50, 70};
        for (int n : datos) {
            arbol.insert(n);
        }

        System.out.println("Recorrido InOrder del BST:");
        System.out.println(arbol.toString());
    }
}
