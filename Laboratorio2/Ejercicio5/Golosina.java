package ejercicio_5;

import java.util.Objects;

class Golosina {
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
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
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
