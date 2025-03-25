package ejercicio_5;

class Caja<T> {
    private String color;
    private T contenido;

    public Caja(String color, T contenido) {
        this.color = color.trim();
        this.contenido = contenido;
    }

    public String getColor() {
        return color;
    }

    public T getContenido() {
        return contenido;
    }

    @Override
    public String toString() {
        return "Caja de color " + color + " --> " + contenido;
    }
}
