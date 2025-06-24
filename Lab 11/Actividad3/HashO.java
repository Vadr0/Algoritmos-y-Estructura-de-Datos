package Actividad3;

// Tabla hash con encadenamiento (listas enlazadas para colisiones)
public class HashO {
    private Node[] table;

    public HashO(int size) {
        table = new Node[size]; // cada posición es cabeza de lista enlazada
    }

    // Función hash básica
    private int hash(int key) {
        return key % table.length;
    }

    // Inserta un registro en la lista correspondiente
    public void insert(int key, String name) {
        int index = hash(key);
        Node newNode = new Node(new Register(key, name));
        newNode.next = table[index];
        table[index] = newNode;
        System.out.println("Insertado: " + key + " en índice " + index);
    }

    // Buscar registro por clave
    public Register search(int key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.data.key == key) return current.data;
            current = current.next;
        }
        return null;
    }

    // Eliminar un registro por clave (eliminación física)
    public void delete(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.data.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Eliminado: " + key + " del índice " + index);
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("No se encontró la clave " + key + " para eliminar.");
    }

    // Mostrar estado de la tabla hash
    public void display() {
        System.out.println("Contenido de la tabla hash:");
        for (int i = 0; i < table.length; i++) {
            System.out.print("[" + i + "] ");
            Node current = table[i];
            if (current == null) {
                System.out.println("VACÍO");
            } else {
                while (current != null) {
                    System.out.print(current.data + " -> ");
                    current = current.next;
                }
                System.out.println("null");
            }
        }
    }
}
