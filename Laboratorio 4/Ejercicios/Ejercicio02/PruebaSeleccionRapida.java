package Ejercicio02;

public class PruebaSeleccionRapida {

    public static void main(String[] args) {
        // Probamos el algoritmo con diferentes entradas
        System.out.println(SeleccionRapida.seleccionarKEsimo(new int[]{4, 2, 7, 10, 4, 17}, 3));  // 4
        System.out.println(SeleccionRapida.seleccionarKEsimo(new int[]{4, 2, 7, 10, 4, 1, 6}, 5));  // 6
        System.out.println(SeleccionRapida.seleccionarKEsimo(new int[]{4, 2, 7, 1, 4, 6}, 1));  // 1
        System.out.println(SeleccionRapida.seleccionarKEsimo(new int[]{9, 2, 7, 1, 7}, 4));  // 7
    }
}
