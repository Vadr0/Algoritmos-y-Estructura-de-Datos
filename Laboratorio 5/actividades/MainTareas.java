package actividades;

public class MainTareas {
    public static void main(String[] args) {
        // 1. Crear una instancia de GestorDeTareas<T>
        GestorDeTareas<Tarea> gestorTareas = new GestorDeTareas<>();
        
        System.out.println("*********************************************************************************");
        System.out.println("Agregar Tareas:");
        // 2. Agregar tareas
        gestorTareas.agregarTarea(new Tarea("Terminar lab de AED", 3, "Terminar el laboratorio 05 de AED, antes del 30"));
        gestorTareas.agregarTarea(new Tarea("Estudiar para el parcial", 5, "Estudiar para el examen de recuperacion"));
        gestorTareas.agregarTarea(new Tarea("Enviar correo a grupo", 2, "Enviar Correo respecto al trabajo final de Redes II"));
        gestorTareas.agregarTarea(new Tarea("Terminar la base de datos para ADS", 4, "Finalizar la base de datos que estabamos realizando"));
        gestorTareas.agregarTarea(new Tarea("Preparar exposicion de segunda fase", 1, "Terminar el PPT y coordinar"));

        System.out.println("*********************************************************************************");
        System.out.println("Mostrar la Lista de tareas:");
        // 2.1 Mostrar Tareas
        gestorTareas.imprimirTareas();

        System.out.println("*********************************************************************************");
        System.out.println("Eliminar alguna tarea:");
        // 3. Eliminar alguna tarea
        Tarea tareaAEliminar = new Tarea("Enviar correo a grupo", 2, "Enviar Correo respecto al trabajo final de Redes II");
        gestorTareas.eliminarTarea(tareaAEliminar);

        

    }
    
}
