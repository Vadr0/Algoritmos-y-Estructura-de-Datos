package Ejercicio02;
import java.util.Random;

public class SeleccionRapida {

    //encontrar el k-ésimo elemento más pequeño
    public static int seleccionarKEsimo(int[] arreglo, int k) {
        // Convertimos k a índice basado en 0
        return seleccionarKEsimoAux(arreglo, 0, arreglo.length - 1, k - 1);
    }

    // Funcion auxiliar recursiva
    private static int seleccionarKEsimoAux(int[] arreglo, int inicio, int fin, int k) {
        if (inicio == fin) {
            return arreglo[inicio];
        }

        // Seleccionamos un pivote aleatorio
        int indicePivote = particionar(arreglo, inicio, fin);

        // El pivote está en su posición final después de la partición
        if (k == indicePivote) {
            return arreglo[k];
        } else if (k < indicePivote) {
            // Buscar en la parte izquierda
            return seleccionarKEsimoAux(arreglo, inicio, indicePivote - 1, k);
        } else {
            // Buscar en la parte derecha
            return seleccionarKEsimoAux(arreglo, indicePivote + 1, fin, k);
        }
    }

    // Función para hacer la partición
    private static int particionar(int[] arreglo, int inicio, int fin) {
        Random generadorAleatorio = new Random();
        int indicePivote = generadorAleatorio.nextInt(fin - inicio + 1) + inicio;
        int valorPivote = arreglo[indicePivote];

        // Mover el pivote al final
        intercambiar(arreglo, indicePivote, fin);
        int indiceAlmacenamiento = inicio;

        // Reorganizar el arreglo: los menores que el pivote a la izquierda, los mayores a la derecha
        for (int i = inicio; i < fin; i++) {
            if (arreglo[i] < valorPivote) {
                intercambiar(arreglo, indiceAlmacenamiento, i);
                indiceAlmacenamiento++;
            }
        }

        // Mover el pivote a su posición final
        intercambiar(arreglo, indiceAlmacenamiento, fin);
        return indiceAlmacenamiento;
    }

    // Función para intercambiar dos elementos en el arreglo
    private static void intercambiar(int[] arreglo, int i, int j) {
        int temporal = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temporal;
    }
}
