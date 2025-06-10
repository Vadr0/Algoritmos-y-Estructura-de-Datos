package Ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class GrafoDirigido {
    private List<Vertice> vertices;

    public GrafoDirigido() {
        this.vertices = new ArrayList<>();
    }

    public void insertarVertice(String dato) {
        if (!existeVertice(dato)) {
            vertices.add(new Vertice(dato));
        }
    }

    public void insertarArista(String origen, String destino, int peso) {
        Vertice vOrigen = obtenerVertice(origen);
        Vertice vDestino = obtenerVertice(destino);
        if (vOrigen != null && vDestino != null) {
            Arista arista = new Arista(vOrigen, vDestino, peso);
            vOrigen.agregarArista(arista);
        }
    }

    public Vertice obtenerVertice(String dato) {
        for (Vertice v : vertices) {
            if (v.getDato().equals(dato)) {
                return v;
            }
        }
        return null;
    }

    public boolean existeVertice(String dato) {
        return obtenerVertice(dato) != null;
    }

    public int gradoEntrada(String dato) {
        int contador = 0;
        for (Vertice v : vertices) {
            for (Arista a : v.getAristasSalida()) {
                if (a.getDestino().getDato().equals(dato)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public int gradoSalida(String dato) {
        Vertice v = obtenerVertice(dato);
        return v != null ? v.gradoSalida() : 0;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }
}
