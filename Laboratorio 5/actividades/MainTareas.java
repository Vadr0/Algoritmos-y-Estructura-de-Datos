package actividades;

public class MainTareas {
    public static void main(String[] args) {
        // 1. Crear una instancia de GestorDeTareas<T>
        GestorDeTareas<Tarea> gestorTareas = new GestorDeTareas<>();
        
        System.out.println("*********************************************************************************");

        // 2. Agregar tareas
        System.out.println("Agregar Tareas:");
        gestorTareas.agregarTarea(new Tarea("Terminar lab de AED", 3, "Terminar el laboratorio 05 de AED, antes del 30"));
        gestorTareas.agregarTarea(new Tarea("Estudiar para el parcial", 5, "Estudiar para el examen de recuperacion"));
        gestorTareas.agregarTarea(new Tarea("Enviar correo a grupo", 2, "Enviar Correo respecto al trabajo final de Redes II"));
        gestorTareas.agregarTarea(new Tarea("Terminar la base de datos para ADS", 4, "Finalizar la base de datos que estabamos realizando"));
        gestorTareas.agregarTarea(new Tarea("Preparar exposicion de segunda fase", 1, "Terminar el PPT y coordinar"));

        System.out.println("*********************************************************************************");
        gestorTareas.imprimirTareas();
        System.out.println("*********************************************************************************");

        // 3. Eliminar alguna tarea
        System.out.println("Eliminar alguna tarea:");
        Tarea tareaAEliminar = new Tarea("Enviar correo a grupo", 2, "Enviar Correo respecto al trabajo final de Redes II");
        Tarea tareaInexistente = new Tarea("Cambiar este valor, solo prueba", 0, "Este valor es una prueba");
        gestorTareas.eliminarTarea(tareaAEliminar);
        gestorTareas.eliminarTarea(tareaInexistente);

        System.out.println("*********************************************************************************");
        //4. Imprimir todas las tareas actuales.
        gestorTareas.imprimirTareas();
        System.out.println("*********************************************************************************");

        //5. Verificar si cierta tarea existe
        


        

    }
    
}
