package Ejercicio6;

class Chocolatina implements Equatable {
    private String marca;

    public Chocolatina(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) // Verificamos si obj es null
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        Chocolatina that = (Chocolatina) obj;
        return marca.equals(that.marca);
    }

    @Override
    public String toString() {
        return "Chocolatina{marca='" + marca + "'}";
    }
}
