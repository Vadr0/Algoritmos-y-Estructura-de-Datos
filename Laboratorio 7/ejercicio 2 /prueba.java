
public class Prueba {
    public static void main(String[] args) {
        // Crear árbol 1
        LinkedBST<Integer> arbol1 = new LinkedBST<>();
        int[] datos1 = { 40, 20, 10, 30, 60, 50, 70 };
        for (int val : datos1) {
            arbol1.insert(val);
        }

        // Crear árbol 2
        LinkedBST<Integer> arbol2 = new LinkedBST<>();
        int[] datos2 = { 80, 60, 100, 50, 70, 90, 110 };
        for (int val : datos2) {
            arbol2.insert(val);
        }

        // Mostrar áreas
        System.out.println("Área del árbol 1: " + arbol1.areaBST());
        System.out.println("Área del árbol 2: " + arbol2.areaBST());

        // Comparar áreas
        if (sameArea(arbol1, arbol2)) {
            System.out.println("Ambos árboles tienen la MISMA área.");
        } else {
            System.out.println("Los árboles NO tienen la misma área.");
        }

        // Dibujar ambos árboles
        System.out.println("Dibujando árbol 1...");
        arbol1.drawBST();

        System.out.println("Dibujando árbol 2...");
        arbol2.drawBST();
    }

    // Método sameArea
    public static boolean sameArea(LinkedBST<Integer> a, LinkedBST<Integer> b) {
        return a.areaBST() == b.areaBST();
    }
}
