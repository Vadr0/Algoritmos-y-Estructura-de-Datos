package informe4;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.print("Ingrese la cantidad de números a procesar: ");
        n = scanner.nextInt();

        int pares = 0, impares = 0;
        int positivos = 0, negativos = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int num = scanner.nextInt();

            // Contar pares e impares
            if (num % 2 == 0) {
                pares++;
            } else {
                impares++;
            }

            // Contar positivos y negativos
            if (num > 0) {
                positivos++;
            } else if (num < 0) {
                negativos++;
            }
            // Los ceros no se cuentan como positivos ni negativos
        }

        System.out.println("\nCantidad de números pares: " + pares);
        System.out.println("Cantidad de números impares: " + impares);
        System.out.println("Cantidad de números positivos: " + positivos);
        System.out.println("Cantidad de números negativos: " + negativos);

        scanner.close();
    }
}
