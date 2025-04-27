package Ejercicio2;

public class Main {
    public static void main(String[] args) {
        // creamos nuestra la bolsa para llevar nuestras cosas con un limite 3 elementos
        Bolsa<Golochina> bolsaGolosinas = new Bolsa<>(3);

        // aqui agregamos cosas a nuestra bolsa
        bolsaGolosinas.add(new Golochina("Caramelito de limon --> ", 10.5));
        bolsaGolosinas.add(new Golochina("Chichiste --> ", 5.0));
        bolsaGolosinas.add(new Golochina("Gomita tuburon --> ", 7.8));

        // aqui ya solo montramos el contenido de la bolsa
        System.out.println("en nuestra bolsa solo cabe: ");
        for (Golochina golochina : bolsaGolosinas) {
            System.out.println(golochina);
        }
    }
}
