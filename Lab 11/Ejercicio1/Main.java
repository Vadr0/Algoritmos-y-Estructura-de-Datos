package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        // 1. Insertar sin colisiones
        HashSimple hs = new HashSimple(7);
        hs.insertar(3);
        hs.insertar(10);
        hs.insertar(17);
        hs.insertar(24);
        hs.mostrar();
        System.out.println();

        // 2. Resolver colisiones con sondeo lineal
        HashLineal hl = new HashLineal(6);
        hl.insertar(12);
        hl.mostrar();
        hl.insertar(18);
        hl.mostrar();
        hl.insertar(24);
        hl.mostrar();
        hl.insertar(30);
        hl.mostrar();
        System.out.println("Explicación: Cuando hay colisión, se busca la siguiente posición disponible (sondeo lineal).");
        System.out.println();

        // 3. Buscar en hash abierto
        HashAbierto ha = new HashAbierto(5);
        ha.insertar(10, "Alvaro");
        ha.insertar(15, "Rodrigo");
        ha.insertar(20, "Marcelo");
        ha.insertar(25, "Orla");
        ha.mostrar();
        System.out.println("Buscar clave 20: " + ha.buscar(20));
        System.out.println("Buscar clave 30: " + ha.buscar(30));
        System.out.println("Si la clave no existe, retorna null.");
        System.out.println();

        // 4. Eliminar en hash cerrado
        HashLineal hl2 = new HashLineal(7);
        hl2.insertar(5);
        hl2.insertar(12);
        hl2.insertar(19);
        hl2.mostrar();
        hl2.eliminar(12);
        hl2.mostrar();
        System.out.println("Buscar clave 19 después de eliminar 12: " + hl2.buscar(19));
        System.out.println("Eliminación lógica: marca la posición como borrada, pero no la borra físicamente.");
        System.out.println("Eliminación física: elimina el dato y deja la posición como null.");
    }
}
