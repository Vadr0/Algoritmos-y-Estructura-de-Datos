package Ejercicio3;

class Golosona {
    private String nombre;
    private double peso;

    public Golosona(String nombre, double peso) {
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
