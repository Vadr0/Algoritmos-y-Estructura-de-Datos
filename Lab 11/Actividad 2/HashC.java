package Actividad2;

// Implementación de la tabla hash cerrada con sondeo lineal
public class HashC {
    private Register[] table;
    private int size;

    public HashC(int capacity) {
        table = new Register[capacity];
        size = 0;
    }

    // Función hash básica usando módulo
    private int hash(int key) {
        return key % table.length;
    }

    // Insertar elemento con manejo de colisiones usando sondeo lineal
    public void insert(int key, String name) {
        int index = hash(key);
        int startIndex = index;

        // Recorre hasta encontrar un espacio vacío o marcado como eliminado
        do {
            if (table[index] == null || table[index].deleted) {
                table[index] = new Register(key, name);
                size++;
                System.out.println("Insertado: " + key + " en posición " + index);
                return;
            }
            index = (index + 1) % table.length;
        } while (index != startIndex);

        System.out.println("Tabla llena. No se pudo insertar " + key);
    }

    // Buscar un registro por clave
    public Register search(int key) {
        int index = hash(key);
        int startIndex = index;

        do {
            if (table[index] == null) return null;
            if (!table[index].deleted && table[index].key == key) {
                return table[index];
            }
            index = (index + 1) % table.length;
        } while (index != startIndex);

        return null;
    }

    // Eliminación lógica: solo se marca como eliminado
    public void delete(int key) {
        int index = hash(key);
        int startIndex = index;

        do {
            if (table[index] == null) return;
            if (!table[index].deleted && table[index].key == key) {
                table[index].deleted = true;
                System.out.println("Eliminado lógicamente: " + key + " en posición " + index);
                return;
            }
            index = (index + 1) % table.length;
        } while (index != startIndex);
    }

    // Mostrar estado actual de la tabla
    public void display() {
        System.out.println("Estado actual de la tabla hash:");
        for (int i = 0; i < table.length; i++) {
            System.out.print("[" + i + "] ");
            if (table[i] == null) {
                System.out.println("VACÍO");
            } else {
                System.out.println(table[i]);
            }
        }
    }
}
