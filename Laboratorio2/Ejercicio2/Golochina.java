package Ejercicio2;

class Golochina {
    private String nombre;
    private double peso;

    public Golochina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return nombre + " (" + peso + "g)";
    }
}
