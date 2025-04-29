package actividades;

public class MainTareas {
    public static void main(String[] args) {
        // 1. Crear una instancia de GestorDeTareas<T>
        GestorDeTareas<Tarea> tareasPendientes = new GestorDeTareas<>();
        
        System.out.println("*********************************************************************************");

        // 2. Agregar tareas
        System.out.println("Agregar Tareas:");
        tareasPendientes.agregarTarea(new Tarea("Terminar lab de AED", 3, "Terminar el laboratorio 05 de AED, antes del 30"));
        tareasPendientes.agregarTarea(new Tarea("Estudiar para el parcial", 5, "Estudiar para el examen de recuperacion"));
        tareasPendientes.agregarTarea(new Tarea("Enviar correo a grupo", 2, "Enviar Correo respecto al trabajo final de Redes II"));
        tareasPendientes.agregarTarea(new Tarea("Terminar la base de datos para ADS", 4, "Finalizar la base de datos que estabamos realizando"));
        tareasPendientes.agregarTarea(new Tarea("Preparar exposicion de segunda fase", 1, "Terminar el PPT y coordinar"));

        System.out.println("*********************************************************************************");
        tareasPendientes.imprimirTareas();
        System.out.println("*********************************************************************************");

        // 3. Eliminar alguna tarea
        System.out.println("Eliminar alguna tarea:");
        Tarea tareaAEliminar = new Tarea("Enviar correo a grupo", 2, "Enviar Correo respecto al trabajo final de Redes II");
        Tarea tareaInexistente = new Tarea("Cambiar este valor, solo prueba", 0, "Este valor es una prueba");
        tareasPendientes.eliminarTarea(tareaAEliminar);
        tareasPendientes.eliminarTarea(tareaInexistente);

        System.out.println("*********************************************************************************");
        //4. Imprimir todas las tareas actuales.
        tareasPendientes.imprimirTareas();
        System.out.println("*********************************************************************************");

        //5. Verificar si cierta tarea existe
        System.out.println("Verificar existencia de una tarea:");
        Tarea tareaABuscar = new Tarea("Terminar lab de AED",3,"Terminar el laboratorio 05 de AED");
        Tarea tareaFalsa = new Tarea("Tarea Generica",22,"Sin descripcion");

        System.out.println("La tarea " + tareaABuscar.getTitulo() + " existe? " + (tareasPendientes.contieneTarea(tareaABuscar) ? "Si existe" : "No existe"));
        System.out.println("La tarea " + tareaFalsa.getTitulo() + " existe? " + (tareasPendientes.contieneTarea(tareaFalsa) ? "Si existe" : "No existe"));

        System.out.println("*********************************************************************************");
        //6. Invertir la lista
        System.out.println("Lista sin invertir:");
        tareasPendientes.imprimirTareas();
        System.out.println("*********************************************************************************");
        System.out.println("Invertiendo la lista:");
        tareasPendientes.invertirListaTareas();
        tareasPendientes.imprimirTareas();        

        System.out.println("*********************************************************************************");
        //7. Transferir una tarea a una lista de “tareas completadas” (List<T>).
        GestorDeTareas<Tarea> tareasCompletadas = new GestorDeTareas<>();
        Tarea tareaCompletada = new Tarea("Terminar la base de datos para ADS", 4, "Finalizar la base de datos que estabamos realizando");

        tareasCompletadas.agregarTarea(tareaCompletada);
        tareasPendientes.eliminarTarea(tareaCompletada);

        System.out.println("\nTareas pendientes:");
        tareasPendientes.imprimirTareas();

        System.out.println("\nTareas completadas:");
        tareasCompletadas.imprimirTareas();


        

    }
    
}
