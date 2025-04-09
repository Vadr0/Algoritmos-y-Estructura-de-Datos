package no_quiero_exponer;
import java.util.ArrayList;
import java.util.List;

public class SubconjuntoPotencias {

    public static void main(String[] args) {
        // Casos que deben devolver TRUE (existe subconjunto que suma al objetivo)
        int[] entrada1 = {4, 2, 4, 8, 16, 30};    // true (2+4+8+16 = 30)
        int[] entrada2 = {5, 5, 10, 20, 2, 8, 45}; // true (5+10+20+8+2 = 45)
        int[] entrada3 = {3, 8, 16, 5, 29};        // true (8+16+5 = 29)
        
        // Casos que deben devolver FALSE (no existe subconjunto que suma al objetivo)
        int[] entrada4 = {4, 2, 4, 8, 16, 31};    // false (no suma 31)
        int[] entrada5 = {5, 5, 10, 20, 2, 8, 44}; // false (no suma 44)
        int[] entrada6 = {3, 8, 16, 5, 30};        // false (no suma 30)
        int[] entrada7 = {5, 2, 16, 8, 32, 64, 126};// false (2+16+8+32+64 = 122 ≠ 126)

        System.out.println("TRUE CASES:");
        System.out.println(puedeAlcanzarObjetivo(entrada1)); // true
        System.out.println(puedeAlcanzarObjetivo(entrada2)); // true
        System.out.println(puedeAlcanzarObjetivo(entrada3)); // true
        
        System.out.println("\nFALSE CASES:");
        System.out.println(puedeAlcanzarObjetivo(entrada4)); // false
        System.out.println(puedeAlcanzarObjetivo(entrada5)); // false
        System.out.println(puedeAlcanzarObjetivo(entrada6)); // false
        System.out.println(puedeAlcanzarObjetivo(entrada7)); // false
    }

    public static boolean puedeAlcanzarObjetivo(int[] entrada) {
        int N = entrada[0];
        if (entrada.length != N + 2) {
            return false;
        }
        
        int[] arreglo = new int[N];
        System.arraycopy(entrada, 1, arreglo, 0, N);
        int objetivo = entrada[N + 1];

        List<Integer> numerosFiltrados = new ArrayList<>();

        for (int i = 0; i < arreglo.length; i++) {
            int num = arreglo[i];
            
            if (esPotenciaDeDos(num)) {
                numerosFiltrados.add(num);
            } 
            else if (num % 5 == 0) {
                if (i == arreglo.length - 1 || arreglo[i + 1] % 2 == 0) {
                    numerosFiltrados.add(num);
                }
            }
        }

        return existeSubconjunto(numerosFiltrados, objetivo);
    }

    private static boolean esPotenciaDeDos(int num) {
        return num > 0 && (num & (num - 1)) == 0;
    }

    private static boolean existeSubconjunto(List<Integer> numeros, int objetivo) {
        return backtrack(numeros, 0, objetivo);
    }

    private static boolean backtrack(List<Integer> numeros, int index, int objetivo) {
        if (objetivo == 0) return true;
        if (index >= numeros.size() || objetivo < 0) return false;
        return backtrack(numeros, index + 1, objetivo - numeros.get(index)) ||
               backtrack(numeros, index + 1, objetivo);
    }
}
