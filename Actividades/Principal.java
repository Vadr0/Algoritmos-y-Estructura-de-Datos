package Actividades;

public class Principal {
    public static void main(String[] args) {
        Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(3);
        Bolsa<Golosina> bolsaGo = new Bolsa<Golosina>(3);

        Chocolatina c = new Chocolatina("milka");
        Chocolatina c1 = new Chocolatina("milka");
        Chocolatina c2 = new Chocolatina("ferrero");
        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);
        System.out.println("\nChocolatinas en la bolsa:");
        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }
        // Llenamos la bolsa de golosinas
        Golosina g1 = new Golosina("Gomitas", 200);
        Golosina g2 = new Golosina("Caramelo", 12.49);
        Golosina g3 = new Golosina("Chicle", 12.34);

        bolsaGo.add(g1);
        bolsaGo.add(g2);
        bolsaGo.add(g3);

        // Imprimir contenido de la bolsa de golosinas
        System.out.println("\nGolosinas en la bolsa:");
        for (Golosina golosina : bolsaGo) {
            System.out.println(golosina.getNombre());
        }
    }
}