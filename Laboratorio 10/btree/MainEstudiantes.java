package btree;

public class MainEstudiantes {
    public static void main(String[] args) {
        BTree<RegistroEstudiante> btree = new BTree<>(4);
        // Insertar estudiantes
        btree.insert(new RegistroEstudiante(103, "Ana"));
        btree.insert(new RegistroEstudiante(110, "Luis"));
        btree.insert(new RegistroEstudiante(101, "Carlos"));
        btree.insert(new RegistroEstudiante(120, "Lucía"));
        btree.insert(new RegistroEstudiante(115, "David"));
        btree.insert(new RegistroEstudiante(125, "Jorge"));
        btree.insert(new RegistroEstudiante(140, "Camila"));
        btree.insert(new RegistroEstudiante(108, "Rosa"));
        btree.insert(new RegistroEstudiante(132, "Ernesto"));
        btree.insert(new RegistroEstudiante(128, "Denis"));
        btree.insert(new RegistroEstudiante(145, "Enrique"));
        btree.insert(new RegistroEstudiante(122, "Karina"));
        btree.insert(new RegistroEstudiante(108, "Juan")); // Duplicado, no se insertará

        // Buscar estudiantes
        System.out.println("Buscar 115: " + btree.buscarNombre(115)); // David
        System.out.println("Buscar 132: " + btree.buscarNombre(132)); // Ernesto
        System.out.println("Buscar 999: " + btree.buscarNombre(999)); // No encontrado

        // Eliminar estudiante con código 101
        btree.remove(new RegistroEstudiante(101, "Carlos"));
        // Insertar nuevo estudiante
        btree.insert(new RegistroEstudiante(106, "Sara"));
        // Buscar nuevo estudiante
        System.out.println("Buscar 106: " + btree.buscarNombre(106)); // Sara
    }
}
