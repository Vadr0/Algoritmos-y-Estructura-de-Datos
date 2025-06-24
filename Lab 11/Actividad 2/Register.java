package Actividad2;

// Clase que representa un registro con clave (key) y nombre (name)
public class Register {
    int key;
    String name;
    boolean deleted; // Para indicar eliminación lógica

    public Register(int key, String name) {
        this.key = key;
        this.name = name;
        this.deleted = false;
    }

    public String toString() {
        return key + " - " + name + (deleted ? " [ELIMINADO]" : "");
    }
}
