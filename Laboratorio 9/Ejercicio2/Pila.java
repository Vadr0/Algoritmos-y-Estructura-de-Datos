package Ejercici2;

public class Pila {
    private String[] elementos;
    private int tope;

    public Pila() {
        elementos = new String[100];
        tope = -1;
    }

    public void apilar(String valor) {
        elementos[++tope] = valor;
    }

    public String desapilar() {
        return tope >= 0 ? elementos[tope--] : null;
    }

    public boolean estaVacia() {
        return tope < 0;
    }

    public String[] contenido() {
        String[] copia = new String[tope + 1];
        for (int i = 0; i <= tope; i++) copia[i] = elementos[i];
        return copia;
    }
}
