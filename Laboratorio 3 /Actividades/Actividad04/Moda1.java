package Actividad04;

public class Moda1 {
    public static int moda01(int array[]) {
        int first = 0;
        int end = array.length - 1;

        // Si el array tiene solo un elemento
        if (first == end)
            return array[first]; // Devuelve el único valor

        int moda = array[first];
        int maxfrec = frecuencia(array, first, end, moda); // Calcula la frecuencia del primer elemento

        // Recorre el array desde el segundo elemento
        for (int i = first + 1; i <= end; i++) {
            int frec = frecuencia(array, i, end, array[i]);
            if (frec > maxfrec) {
                maxfrec = frec;
                moda = array[i]; // Actualiza la moda si se encuentra una frecuencia mayor
            }
        }
        return moda; // Devuelve la moda encontrada
    }

    private static int frecuencia(int[] array, int first, int end, int ele) {
        int suma = 0;
        for (int i = first; i <= end; i++) {
            if (array[i] == ele) {
                suma++;
            }
        }
        return suma;
    }

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 2, 2, 3, 3, 3 };
        int result = moda01(array);
        System.out.println("La moda es: " + result); // Imprime la moda
    }
}
