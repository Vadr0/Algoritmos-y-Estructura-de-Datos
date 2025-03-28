package Ejercicio6;

public class TestGen {
    public static <T> boolean exist(T[] array, T elemento) {
        for (T item : array) {
            if (item.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Muchacaja<Chocolatina> baul = new Muchacaja<>(5);
        baul.addCaja(new Caja<>("Rojo", new Chocolatina("Milka")));
        baul.addCaja(new Caja<>("Azul", new Chocolatina("Kinder")));
        baul.addCaja(new Caja<>("Verde", new Chocolatina("Snickers")));
        baul.addCaja(new Caja<>("Amarillo", new Chocolatina("Ferrero Rocher")));
        baul.addCaja(new Caja<>("Morado", new Chocolatina("Lindt")));

        System.out.println("Estado del baúl:");
        System.out.println(baul);

        System.out.println("\nBuscando chocolatinas:");
        System.out.println(baul.search(new Chocolatina("Kinder")));
        System.out.println(baul.search(new Chocolatina("Snickers")));
        System.out.println(baul.search(new Chocolatina("Nestlé")));

        System.out.println("\nEliminando chocolatina:");
        System.out.println("Se eliminó: " + baul.delete(new Chocolatina("Ferrero Rocher")));

        System.out.println("\nEstado del baúl después de eliminar:");
        System.out.println(baul);
    }
}
