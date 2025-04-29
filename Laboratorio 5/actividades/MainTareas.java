package actividades;

public class MainTareas {
    public static void main(String[] args) {
        // 1. Crear una instancia de GestorDeTareas<T>
        GestorDeTareas<Tarea> gestorTareas = new GestorDeTareas<>();
        
        System.out.println("*********************************************************************************");
        System.out.println("Agregar Tareas");
        // 2. Agregar tareas
        gestorTareas.agregarTarea(new Tarea("Terminar lab de ADS", 3, "Terminar el laboratorio 05 de ADS, antes del 30"));
        gestorTareas.agregarTarea(new Tarea("Estudiar para el parcial", 5, "Estudiar para el examen de recuperacion"));
        gestorTareas.agregarTarea(new Tarea("Enviar correo a grupo", 2, "Enviar Correo respecto al trabajo final de Redes II"));

        System.out.println("*********************************************************************************");
        System.out.println("Mostrar la Lista de tareas:");
        gestorTareas.imprimirTareas();

    }
    
}
