package Ejercicio3;

import java.util.ArrayList;
import java.util.Iterator;

class Muchacaja<T> implements Iterable<Caja<T>> {
    private ArrayList<Caja<T>> lista = new ArrayList<>();
    private int tope;

    public Muchacaja(int tope) {
        this.tope = tope;
    }

    public void addCaja(Caja<T> caja) {
        if (lista.size() < tope) {
            lista.add(caja);
        } else {
            throw new RuntimeException("No caben más cajas en el baul");
        }
    }

    public Iterator<Caja<T>> iterator() {
        return lista.iterator();
    }
}