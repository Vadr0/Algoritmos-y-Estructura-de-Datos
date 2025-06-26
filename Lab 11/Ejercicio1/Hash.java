package Ejercicio1;

public interface Hash {
    void insertar(int clave, String valor); // Para tablas con valor asociado
    void insertar(int clave); // Para tablas solo con claves
    String buscar(int clave);
    void eliminar(int clave);
    void mostrar();
}
