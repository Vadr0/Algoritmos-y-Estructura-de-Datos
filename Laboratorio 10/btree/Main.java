package btree;

public class Main {
    public static void main(String[] args) {

        BTree<Integer> btree = new BTree<>(4);


        int[] valores = {3, 10, 12, 13, 16, 19, 22, 25, 28, 31, 33, 35, 40, 41, 49, 52, 55, 57, 60, 62, 63, 67, 70, 72};
        for (int v : valores) {
            btree.insert(v);
        }


        System.out.println(btree);

        // Buscar y mostrar si existe la clave 52
        System.out.println("¿Está 52 en el árbol?: " + btree.search(52));
        // Puedes probar con otros valores también
        System.out.println("¿Está 100 en el árbol?: " + btree.search(100));
    }
}
