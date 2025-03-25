package ejercicio_5;

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
        Muchacaja<Golosina> baul = new Muchacaja<>(5);
        baul.addCaja(new Caja<>("Rojo", new Golosina("Caramelito de limon", 10.5)));
        baul.addCaja(new Caja<>("Azul", new Golosina("Chichiste", 5.0)));
        baul.addCaja(new Caja<>("Verde", new Golosina("Gomita tiburon", 7.8)));
        baul.addCaja(new Caja<>("Amarillo", new Golosina("Chocolate", 15.0)));
        baul.addCaja(new Caja<>("Morado", new Golosina("Dulce de leche", 12.3)));

        System.out.println("Estado del baúl:");
        System.out.println(baul);

        System.out.println("\nBuscando golosinas:");
        System.out.println(baul.search(new Golosina("Chichiste", 5.0)));
        System.out.println(baul.search(new Golosina("Gomita tiburon", 7.8)));
        System.out.println(baul.search(new Golosina("Dulce inexistente", 3.0)));

        System.out.println("\nEliminando golosina:");
        System.out.println("Se eliminó: " + baul.delete(new Golosina("Chocolate", 15.0)));

        System.out.println("\nEstado del baúl después de eliminar:");
        System.out.println(baul);
    }
}
