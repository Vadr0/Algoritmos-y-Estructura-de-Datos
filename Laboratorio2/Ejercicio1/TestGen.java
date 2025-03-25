package Ejercicio1;

public class TestGen {
    // Método genérico para verificar si un elemento existe en un arreglo
    public static <T> boolean exist(T[] array, T elemento) {
        for (T item : array) {
            if (item.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String[] nombres = { "Montoya", "Delgado", "Montenegro", "Ponce" };
        System.out.println(exist(nombres, "Montoya"));
        System.out.println(exist(nombres, "Velazquez"));

        Integer[] numeros = { 2, 22, 17 };
        System.out.println(exist(numeros, 22));
        System.out.println(exist(numeros, 78));

        Golosina[] golosinas = {
                new Golosina("Caramelito de limon", 10.5),
                new Golosina("Chichiste", 5.0),
                new Golosina("Gomita tiburon ", 7.8)
        };
        System.out.println(exist(golosinas, new Golosina("Chichiste", 5.0)));

        Chocolatina[] chocolatinas = {
                new Chocolatina("Fondy"),
                new Chocolatina("Milky"),
                new Chocolatina("Sublime")
        };
        System.out.println(exist(chocolatinas, new Chocolatina("Fondy")));
    }
}
