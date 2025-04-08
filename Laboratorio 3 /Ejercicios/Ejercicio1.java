import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int mayor = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int suma = 0, contador = 0;

        System.out.println("Ingrese números enteros positivos (termine con un número negativo):");

        while (true) {
            num = scanner.nextInt();

            if (num < 0) {
                break;
            }

            if (num > mayor) {
                mayor = num;
            }
            if (num < menor) {
                menor = num;
            }

            suma += num;
            contador++;
        }

        if (contador > 0) {
            double promedio = (double) suma / contador;
            System.out.println("\nNúmero mayor: " + mayor);
            System.out.println("Número menor: " + menor);
            System.out.println("Promedio: " + promedio);
        } else {
            System.out.println("\nNo se ingresaron números positivos.");
        }

        scanner.close();
    }
}
