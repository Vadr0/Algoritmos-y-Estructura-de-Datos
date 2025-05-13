public class Prueba {
    public static <E extends Comparable<E>> boolean sameArea(LinkedBST<E> tree1, LinkedBST<E> tree2) {
        return tree1.areaBST() == tree2.areaBST();
    }
}
