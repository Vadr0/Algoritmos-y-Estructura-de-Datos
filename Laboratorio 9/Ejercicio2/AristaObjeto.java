package Ejercicio2;

public class Arista {
    public Vertice destino;
    public int peso;
    public Arista siguiente;

    public Arista(Vertice destino, int peso) {
        this.destino = destino;
        this.peso = peso;
        this.siguiente = null;
    }
}

