package Ejercicio1;

public class HashAbierto implements Hash {
    private ListaEnlazada[] tabla;

    static class Nodo {
        int clave;
        String valor;
        Nodo(int clave, String valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    // Lista enlazada simple para encadenamiento
    static class NodoLista {
        Nodo dato;
        NodoLista siguiente;
        NodoLista(Nodo dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    static class ListaEnlazada {
        NodoLista cabeza;

        void agregar(Nodo n) {
            NodoLista nuevo = new NodoLista(n);
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                NodoLista actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }

        Nodo buscar(int clave) {
            NodoLista actual = cabeza;
            while (actual != null) {
                if (actual.dato.clave == clave) return actual.dato;
                actual = actual.siguiente;
            }
            return null;
        }

        void mostrar() {
            NodoLista actual = cabeza;
            while (actual != null) {
                System.out.print("[" + actual.dato.clave + ", " + actual.dato.valor + "] ");
                actual = actual.siguiente;
            }
        }
    }

    public HashAbierto(int tam) {
        tabla = new ListaEnlazada[tam];
        for (int i = 0; i < tam; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }

    @Override
    public void insertar(int clave, String valor) {
        int pos = clave % tabla.length;
        tabla[pos].agregar(new Nodo(clave, valor));
    }

    @Override
    public String buscar(int clave) {
        int pos = clave % tabla.length;
        Nodo n = tabla[pos].buscar(clave);
        return n != null ? n.valor : null;
    }

    @Override
    public void mostrar() {
        System.out.println("Tabla Hash Abierto (Encadenamiento):");
        for (int i = 0; i < tabla.length; i++) {
            System.out.print(i + ": ");
            tabla[i].mostrar();
            System.out.println();
        }
    }

    // Métodos no usados en este ejemplo
    @Override public void insertar(int clave) {}
    @Override public void eliminar(int clave) {}
}
