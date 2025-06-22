package btree;

public class Main2 {
    public static void main(String[] args) {
        try {
            // ejercicio 3: Construir el árbol desde arbolB.txt
            BTree<Integer> btree = BTree.building_Btree("arbolB.txt", Integer::parseInt);
            System.out.println("Árbol B cargado desde archivo:");
            System.out.println(btree);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
