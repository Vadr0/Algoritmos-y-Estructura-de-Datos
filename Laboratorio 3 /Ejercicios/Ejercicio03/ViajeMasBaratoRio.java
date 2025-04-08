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
        // Ejemplo: matriz triangular superior
        int[][] T = {
            { 0, 3, 1, 6, Integer.MAX_VALUE },
            { 0, 0, 1, 2, 4 },
            { 0, 0, 0, 1, 2 },
            { 0, 0, 0, 0, 1 },
            { 0, 0, 0, 0, 0 }
        };

        int[][] C = calcularCostosMinimos(T);

        System.out.println("Matriz de costos mínimos:");
        imprimirMatriz(C);
    }
}
