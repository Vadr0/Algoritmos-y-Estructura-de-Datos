package btree;

import java.util.ArrayList;

public class BNode<E extends Comparable<E>> {
    protected ArrayList<E> keys;
    protected ArrayList<BNode<E>> childs;
    protected int count;

    public BNode (int n) {
        this.keys = new ArrayList<E>(n);
        this.childs = new ArrayList<BNode<E>>(n);
        this.count = 0;
        for (int i = 0; i < n;i++){
            this.keys.add(null);
            this.childs.add(null);
        }
    }
    
    public boolean nodeFull(){
        // lleno si count es tamaño de claves
        return count == keys.size();
    }
    
    public boolean nodeEmpty() {
        // vacio si count es 0
        return count == 0;
    }

    // Clase interna para el resultado de búsqueda
    public static class SearchResult {
        public boolean found;
        public int position;
        public SearchResult(boolean found, int position) {
            this.found = found;
            this.position = position;
        }
    }

    // Busca una clave en el nodo actual
    public SearchResult searchNode(E key) {
        int i = 0;
        while (i < count && keys.get(i) != null && key.compareTo(keys.get(i)) > 0) {
            i++;
        }

        if (i < count && keys.get(i) != null && key.compareTo(keys.get(i)) == 0) {
            return new SearchResult(true, i); // esta en la posición i
        } else {
            return new SearchResult(false, i); // se debe descender, no encontro
        }
    }
    
    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < count; i++) {
            result += keys.get(i);
            if (i < count - 1) result += ", ";
        }
        result += "]";
        return result;
    }
}