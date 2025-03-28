package Ejercicio5;

import java.util.Objects;

class Golosina implements Equatable {
    private String nombre;
    private double peso;

    public Golosina(String nombre, double peso) {
        this.nombre = nombre.trim();
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) // Verifficamos si obj es null
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Golosina golosina = (Golosina) obj;
        return Double.compare(golosina.peso, peso) == 0 && nombre.equals(golosina.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, peso);
    }

    @Override
    public String toString() {
        return nombre + " (" + peso + "g)";
    }
}
