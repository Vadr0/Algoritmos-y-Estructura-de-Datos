package Ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String dato;
    private List<Arista> aristasSalida;

    public Vertice(String dato) {
        this.dato = dato;
        this.aristasSalida = new ArrayList<>();
    }

    public String getDato() {
        return dato;
    }

    public List<Arista> getAristasSalida() {
        return aristasSalida;
    }

    public void agregarArista(Arista arista) {
        aristasSalida.add(arista);
    }

    public int gradoSalida() {
        return aristasSalida.size();
    }
}
