package Actividad3;

// Clase que representa un registro con clave y nombre
public class Register {
    int key;
    String name;

    public Register(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return key + " - " + name;
    }
}
