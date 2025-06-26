package Ejercicio1;

public class HashSimple implements Hash {
    private Integer[] tabla;

    public HashSimple(int tam) {
        tabla = new Integer[tam];
    }

    @Override
    public void insertar(int clave) {
        int pos = clave % tabla.length;
        if (tabla[pos] == null) {
            tabla[pos] = clave;
        } else {
            System.out.println("Colisión al insertar " + clave + " en la posición " + pos);
        }
    }

    @Override
    public void mostrar() {
        System.out.println("Tabla Hash Simple:");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println(i + ": " + tabla[i]);
        }
    }

    // Métodos no usados en este ejemplo
    @Override public void insertar(int clave, String valor) {}
    @Override public String buscar(int clave) { return null; }
    @Override public void eliminar(int clave) {}
}
