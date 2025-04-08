public class ViajeMasBaratoRio {

    public static int[][] calcularCostosMinimos(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];

        // Inicializamos C con infinito (salvo la diagonal, que es 0)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    C[i][j] = 0;
                } else {
                    C[i][j] = T[i][j] > 0 ? T[i][j] : Integer.MAX_VALUE;
                }
            }
        }

        // Programación dinámica: para cada longitud de tramo
        for (int longitud = 2; longitud <= n; longitud++) {
            for (int i = 0; i <= n - longitud; i++) {
                int j = i + longitud - 1;
                for (int k = i + 1; k < j; k++) {
                    if (C[i][k] != Integer.MAX_VALUE && C[k][j] != Integer.MAX_VALUE) {
                        C[i][j] = Math.min(C[i][j], C[i][k] + C[k][j]);
                    }
                }
            }
        }

        return C;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(valor + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Ejemplo 1: matriz triangular superior (original)
        int[][] T1 = {
            { 0, 3, 1, 6, Integer.MAX_VALUE },
            { 0, 0, 1, 2, 4 },
            { 0, 0, 0, 1, 2 },
            { 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 0 }
        };
    
        System.out.println("Ejemplo 1:");
        int[][] C1 = calcularCostosMinimos(T1);
        imprimirMatriz(C1);
        System.out.println();
    
        // Ejemplo 2: caminos más costosos y más "directos"
        int[][] T2 = {
            { 0, 10, 100, Integer.MAX_VALUE, Integer.MAX_VALUE },
            { 0, 0, 5, 50, Integer.MAX_VALUE },
            { 0, 0, 0, 2, 20 },
            { 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 0 }
        };
    
        System.out.println("Ejemplo 2:");
        int[][] C2 = calcularCostosMinimos(T2);
        imprimirMatriz(C2);
        System.out.println();
    
        // Ejemplo 3: muchos caminos directos y cortos
        int[][] T3 = {
            { 0, 1, 2, 3, 4 },
            { 0, 0, 1, 1, 1 },
            { 0, 0, 0, 1, 1 },
            { 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 0 }
        };
    
        System.out.println("Ejemplo 3:");
        int[][] C3 = calcularCostosMinimos(T3);
        imprimirMatriz(C3);
        System.out.println();
    }
}    
