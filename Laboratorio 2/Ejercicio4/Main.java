package Ejercicio4;

public class Main {
    public static void main(String[] args) {
        // creamos un baul con una capacidad de 5 cosas
        Muchacaja<Golosina> baul = new Muchacaja<>(5);

        // agregamos cosas al baul 
        baul.addCaja(new Caja<>("marron", new Golosina("Caramelito bambi ", 10.5)));
        baul.addCaja(new Caja<>("Azul", new Golosina("Chicle huevito ", 5.0)));
        baul.addCaja(new Caja<>("amarillo", new Golosina("1 chizito ", 7.8)));
        baul.addCaja(new Caja<>("verdecito", new Golosina("la bomba de Hiroshima ", 100.5)));

        // mostramos el baul
        System.out.println(baul);

        // buscamos algo dentro del baul
        System.out.println(baul.search(new Golosina("Chicle huevito", 5.0))); // Posición: 2, Color: Azul
        System.out.println(baul.search(new Golosina("Caramelito mamá de bambi", 8.0))); // Objeto no encontrado

        // lo sacamos del baul
        System.out.println("Eliminando: " + baul.delete(new Golosina("la bomba de Hiroshima", 100.5)));

        // vemos que queda dentro del baul
        System.out.println(baul);
    }
}
