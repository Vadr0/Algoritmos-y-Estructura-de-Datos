package Ejercicio1;

public class HashLineal implements Hash {
    private Integer[] tabla;
    private boolean[] borrado; // Para eliminación lógica

    public HashLineal(int tam) {
        tabla = new Integer[tam];
        borrado = new boolean[tam];
    }

    @Override
    public void insertar(int clave) {
        int pos = clave % tabla.length;
        int intentos = 0;
        while (tabla[pos] != null && !borrado[pos]) {
            System.out.println("Colisión en " + pos + " al insertar " + clave + ", probando siguiente...");
            pos = (pos + 1) % tabla.length;
            intentos++;
            if (intentos == tabla.length) {
                System.out.println("Tabla llena, no se puede insertar " + clave);
                return;
            }
        }
        tabla[pos] = clave;
        borrado[pos] = false;
        System.out.println("Insertado " + clave + " en posición " + pos);
    }

    @Override
    public void mostrar() {
        System.out.println("Tabla Hash con Sondeo Lineal:");
        for (int i = 0; i < tabla.length; i++) {
            System.out.println(i + ": " + (tabla[i] != null && !borrado[i] ? tabla[i] : "vacío"));
        }
    }

    @Override
    public void eliminar(int clave) {
        int pos = clave % tabla.length;
        int intentos = 0;
        while (tabla[pos] != null && intentos < tabla.length) {
            if (tabla[pos] == clave && !borrado[pos]) {
                borrado[pos] = true; // Eliminación lógica
                System.out.println("Eliminado " + clave + " en posición " + pos);
                return;
            }
            pos = (pos + 1) % tabla.length;
            intentos++;
        }
        System.out.println("Clave " + clave + " no encontrada para eliminar.");
    }

    @Override
    public String buscar(int clave) {
        int pos = clave % tabla.length;
        int intentos = 0;
        while (tabla[pos] != null && intentos < tabla.length) {
            if (tabla[pos] == clave && !borrado[pos]) {
                return "Encontrado en posición " + pos;
            }
            pos = (pos + 1) % tabla.length;
            intentos++;
        }
        return "No encontrado";
    }

    // Métodos no usados en este ejemplo
    @Override public void insertar(int clave, String valor) {}
}
