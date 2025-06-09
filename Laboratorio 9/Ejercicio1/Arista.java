package Ejercicio1;

public class Arista {
    private Vertice destino;
    private int peso;

    public Arista(Vertice destino) {
        this.destino = destino;
        this.peso = 1;
    }

    public Arista(Vertice destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice obtenerVertice() {
        return destino;
    }

    public int obtenerPeso() {
        return peso;
    }
}
