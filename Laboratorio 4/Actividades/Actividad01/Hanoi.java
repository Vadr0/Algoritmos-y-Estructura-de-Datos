package Actividad01;

public class Hanoi {
    // Contador estático para los movimientos
    static int contadorMovimientos = 0;

    public static void main(String[] args) {
        torresHanoi(5, 1, 2, 3); 
        System.out.println();
        System.out.println("Número total de movimientos: " + contadorMovimientos);
    }

    public static void torresHanoi(int discos, int torre1, int torre2, int torre3) {
        // Caso base: si solo queda un disco, se mueve
        if (discos == 1) {
            contadorMovimientos++;  
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
        } else {
            // Mover los discos superiores a la torre auxiliar
            torresHanoi(discos - 1, torre1, torre3, torre2);
            //Mover el disco más grande a la torre de destino
            contadorMovimientos++;  
            System.out.println("Mover disco de torre " + torre1 + " a torre " + torre3);
            // Mover los discos de la torre auxiliar a la torre de destino
            torresHanoi(discos - 1, torre2, torre1, torre3);
        }
    }
}
