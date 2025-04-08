package informe4;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int TAM = 10; // Tamaño fijo de los arreglos

        int[] arreglo1 = new int[TAM];
        int[] arreglo2 = new int[TAM];
        int[] suma = new int[TAM];

        System.out.println("Ingrese los elementos del primer arreglo:");
        for (int i = 0; i < TAM; i++) {
            System.out.print("Elemento " + i + ": ");
            arreglo1[i] = scanner.nextInt();
        }

        System.out.println("\nIngrese los elementos del segundo arreglo:");
        for (int i = 0; i < TAM; i++) {
            System.out.print("Elemento " + i + ": ");
            arreglo2[i] = scanner.nextInt();
        }

        // Calcular la suma posición por posición
        for (int i = 0; i < TAM; i++) {
            suma[i] = arreglo1[i] + arreglo2[i];
        }

        // Mostrar los tres arreglos
        System.out.println("\nPrimer arreglo:");
        mostrarArreglo(arreglo1);

        System.out.println("\nSegundo arreglo:");
        mostrarArreglo(arreglo2);

        System.out.println("\nArreglo suma:");
        mostrarArreglo(suma);

        scanner.close();
    }

    // Función auxiliar para imprimir arreglos
    public static void mostrarArreglo(int[] arreglo) {
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}
