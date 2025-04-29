package actividades;

public class GestorDeTareas<T> {
    private ListaEnlazada<T> listaTareas;

    //Constructor
    public GestorDeTareas() {
        listaTareas = new ListaEnlazada<>();
    }

    //Agregar Tareas
    public void agregarTarea(T tarea) {
        System.out.println("Tarea: " + tarea + " agregada exitosamente.");
        listaTareas.agregarAlFinal(tarea);
    }

    //Eliminar Tareas
    boolean eliminarTarea(T tarea) {
        if (listaTareas.busca(tarea)) {
            System.out.println("Eliminando la tarea: " + tarea);
            listaTareas.eliminarNodo(tarea);
            return true;
        }
        System.out.println("La tarea " + tarea + " no existe.");
        return false;
    }

    //Buscar Tareas
    boolean contieneTarea(T tarea) {
        return listaTareas.busca(tarea);
    }

    //Imprimir Tareas
    void imprimirTareas(){
        listaTareas.imprimirLista();
    }

    //Ver el tamaño de la lista de tareas
    public int contarTareas(){
        return listaTareas.tamanioLista();
    }

    // Para el metodo obtenerTareaMasPrioritaria, hacemos casting, para que la clase como tal es generica, pero necesitamos utilizar
    // Datos del tipo Tarea, que tengan prioridad
    public Tarea obtenerTareaMasPrioritaria(){
        if (listaTareas.isEmptyList()){
            return null;
        }
        
        Nodo <T> nodoActual = listaTareas.getPrimerNodo();
        //Casteo y ponemos el primer dato, como la mas prioritaria
        Tarea tareaMasPrioritaria = (Tarea) nodoActual.getDato();

        while (nodoActual != null){
            //Casteo y comparamos si la tarea actual tiene mayor prioridad que la guardada
            Tarea tareaActual = (Tarea) nodoActual.getDato();
            if (tareaActual.getPrioridad() > tareaMasPrioritaria.getPrioridad()){
                tareaMasPrioritaria = tareaActual;
            }
            nodoActual = nodoActual.getSiguienteNodo();
        }
        return tareaMasPrioritaria;
    }

    // Método para invertir el orden de la lista enlazada de tareas
    public void invertirListaTareas(){
        Nodo<T> anteriorNodo = null;
        Nodo<T> actualNodo = listaTareas.getPrimerNodo();
        Nodo<T> siguienteNodo = null;
        
        while (actualNodo != null){
            siguienteNodo = actualNodo.getSiguienteNodo();
            actualNodo.setSiguienteNodo(anteriorNodo);
            anteriorNodo = actualNodo;
            actualNodo = siguienteNodo;
        }
        listaTareas.setPrimerNodo(anteriorNodo);
    }
}

/*
public Tarea obtenerTareaMasPrioritaria() {
    if (listaTareas.isEmptyList()) {
        return null;
    }

    Nodo<Tarea> nodoActual = listaTareas.getPrimerNodo();
    Tarea tareaMasPrioritaria = nodoActual.getDato();
    nodoActual = nodoActual.getSiguienteNodo();

    while (nodoActual != null) {
        Tarea tareaActual = nodoActual.getDato();
        if (tareaActual.getPrioridad() > tareaMasPrioritaria.getPrioridad()) {
            tareaMasPrioritaria = tareaActual;
        }
        nodoActual = nodoActual.getSiguienteNodo();
    }

    return tareaMasPrioritaria;
}
*/