package Ejercici2;

public class Vertice {
    public String dato;
    public Vertice siguiente;
    public Arista adyacente;
    public boolean visitado;

    public Vertice(String dato) {
        this.dato = dato;
        this.siguiente = null;
        this.adyacente = null;
        this.visitado = false;
    }
}


    public String toString() {
        return informacion.toString();
    }
}
