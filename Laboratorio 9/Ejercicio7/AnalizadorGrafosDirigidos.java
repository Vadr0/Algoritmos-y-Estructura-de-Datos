package Ejercicio7;

public class AnalizadorGrafosDirigidos {

    public static boolean esCamino(GrafoDirigido grafo) {
        int extremos = 0;
        for (Vertice v : grafo.getVertices()) {
            int entrada = grafo.gradoEntrada(v.getDato());
            int salida = grafo.gradoSalida(v.getDato());

            if ((entrada == 0 && salida == 1) || (entrada == 1 && salida == 0)) {
                extremos++;
            } else if (!(entrada == 1 && salida == 1)) {
                return false;
            }
        }
        return extremos == 2;
    }

    public static boolean esCiclo(GrafoDirigido grafo) {
        for (Vertice v : grafo.getVertices()) {
            int entrada = grafo.gradoEntrada(v.getDato());
            int salida = grafo.gradoSalida(v.getDato());

            if (entrada != 1 || salida != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean esCompleto(GrafoDirigido grafo) {
        int n = grafo.getVertices().size();
        for (Vertice v : grafo.getVertices()) {
            int entrada = grafo.gradoEntrada(v.getDato());
            int salida = grafo.gradoSalida(v.getDato());
            if (entrada != n - 1 || salida != n - 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean esRueda(GrafoDirigido grafo) {
        int n = grafo.getVertices().size();
        int centro = 0, periferia = 0;

        for (Vertice v : grafo.getVertices()) {
            int entrada = grafo.gradoEntrada(v.getDato());
            int salida = grafo.gradoSalida(v.getDato());

            if (salida == n - 1 && entrada == 0) {
                centro++;
            } else if ((entrada == 1 && salida == 2) || (entrada == 2 && salida == 1)) {
                periferia++;
            } else {
                return false;
            }
        }
        return centro == 1 && periferia == n - 1;
    }
}
