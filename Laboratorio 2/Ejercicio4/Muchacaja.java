package Ejercicio4;

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
            throw new RuntimeException("ya no entran consas en el baul.");
        }
    }

    // Método search(): Busca un elemento y devuelve su posición y color de la caja
    public String search(T objeto) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getContenido().equals(objeto)) {
                return "Posición: " + (i + 1) + ", Color: " + lista.get(i).getColor();
            }
        }
        return "Objeto no encontrado";
    }

    // Método delete(): Elimina un objeto de una caja y lo retorna
    public T delete(T objeto) {
        Iterator<Caja<T>> iter = lista.iterator();
        while (iter.hasNext()) {
            Caja<T> caja = iter.next();
            if (caja.getContenido().equals(objeto)) {
                iter.remove();
                return caja.getContenido();
            }
        }
        return null;
    }

    // Método toString(): Devuelve los datos de los objetos en la cajonería
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Baul:\n");
        for (int i = 0; i < lista.size(); i++) {
            sb.append("Posición: ").append(i + 1)
                    .append(", Color -> ").append(lista.get(i).getColor())
                    .append(", Contenido --> ").append(lista.get(i).getContenido()).append("\n");
        }
        return sb.toString();
    }

    public Iterator<Caja<T>> iterator() {
        return lista.iterator();
    }
}
