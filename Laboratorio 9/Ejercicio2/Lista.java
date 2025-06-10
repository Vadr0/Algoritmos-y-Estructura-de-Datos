package Ejercicio2;

public class Lista {
    private String[] datos;
    private int cantidad;

    public Lista() {
        datos = new String[100];
        cantidad = 0;
    }

    public void agregar(String valor) {
        datos[cantidad++] = valor;
    }

    public String obtener(int i) {
        return datos[i];
    }

    public int tamaño() {
        return cantidad;
    }

    public void limpiar() {
        cantidad = 0;
    }

    public boolean contiene(String valor) {
        for (int i = 0; i < cantidad; i++) {
            if (datos[i].equals(valor)) return true;
        }
        return false;
    }

    public String[] obtenerTodos() {
        String[] copia = new String[cantidad];
        for (int i = 0; i < cantidad; i++) copia[i] = datos[i];
        return copia;
    }
}
