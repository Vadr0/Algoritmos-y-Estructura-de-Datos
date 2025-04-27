package Ejercicio3;

public class Main {
    public static void main(String[] args) {

        Muchacaja<Golosona> muchacaja = new Muchacaja<>(5);

        muchacaja.addCaja(new Caja<>("marron", new Golosona("Caramelito bambi ", 10.5)));
        muchacaja.addCaja(new Caja<>("Azul", new Golosona("chicle huevito ", 5.0)));
        muchacaja.addCaja(new Caja<>("amarillo", new Golosona("1 chizito ", 7.8)));
        muchacaja.addCaja(new Caja<>("verdecito", new Golosona("la bomba de Hiroshima ", 100.5)));
        muchacaja.addCaja(new Caja<>("negro", new Golosona("bomba ", 15.0)));

        System.out.println("Contenido del baul:");
        for (Caja<Golosona> caja : muchacaja) {
            System.out.println(caja);
        }
    }
}
