import bstreelinklistinterfgeneric.LinkedBST;

public class Prueba {
    public static void main(String[] args) {
        LinkedBST<Integer> arbol = new LinkedBST<>();

        // Insertar nodos como en el gráfico del laboratorio
        int[] datos = {400, 100, 50, 75, 200, 700};
        for (int n : datos) {
            arbol.insert(n);
        }

        System.out.println("Recorrido PostOrder del BST:");
        System.out.println(arbol.postOrderString());  // Esperado: 75 50 200 100 700 400
    }
}
