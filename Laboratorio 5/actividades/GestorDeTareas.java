package actividades;

public class GestorDeTareas<T> {
    private ListaEnlazada<T> listaTareas;

    public GestorDeTareas() {
        listaTareas = new ListaEnlazada<>();
    }

    public void agregarTarea(T tarea) {
        System.out.println("Tarea: " + tarea + " agregada exitosamente.");
        listaTareas.agregarAlFinal(tarea);
    }

    boolean eliminarTarea(T tarea) {
        if (listaTareas.busca(tarea)) {
            System.out.println("Eliminando la tarea: " + tarea);
            listaTareas.eliminarNodo(tarea);
            return true;
        }
        System.out.println("La tarea no existe.");
        return false;
    }

    boolean contieneTarea(T tarea) {
        return listaTareas.busca(tarea);
    }

    void imprimirTareas(){
        listaTareas.imprimirLista();
    }

    // El metodo para contar tareas, sigue la logica de la busqueda de la lista enlazada, pero el enfoque cambia
    public int contarTareas(){
        int contador = 0;
        Nodo<T> nodoActual = listaTareas.getPrimerNodo();

        while (nodoActual!=null){
            contador++;
            nodoActual = nodoActual.getSiguienteNodo();
        }
        return contador;
    }

    // Para el metodo obtenerTareaMasPrioritaria, hacemos casting, para que la clase como tal es generica, pero necesitamos utilizar
    // Datos del tipo Tarea, que tengan prioridad
    public Tarea obtenerTareaMasPrioritaria(){
        if (listaTareas.isEmptyList()){
            return null;
        }
        
        Nodo <T> nodoActual = listaTareas.getPrimerNodo();
        //Casteo
        Tarea tareaMasPrioritaria = (Tarea) nodoActual.getDato();

        while (nodoActual != null){
            //Casteo
            Tarea tareaActual = (Tarea) nodoActual.getDato();
            if (tareaActual.getPrioridad() > tareaMasPrioritaria.getPrioridad()){
                tareaMasPrioritaria = tareaActual;
            }
            nodoActual = nodoActual.getSiguienteNodo();
        }
        return tareaMasPrioritaria;
    }

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
