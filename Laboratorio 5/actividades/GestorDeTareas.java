package actividades;

public class GestorDeTareas<T> {
    private ListaEnlazada<T> listaTareas;

    public GestorDeTareas() {
        listaTareas = new ListaEnlazada<>();
    }

    public void agregarTarea(T tarea) {
        listaTareas.agregarAlFinal(tarea);
    }

    boolean eliminarTarea(T tarea) {
        if (listaTareas.busca(tarea)) {
            listaTareas.eliminarNodo(tarea);
            return true;
        }
        return false;
    }

    boolean contieneTarea(T tarea) {
        return listaTareas.busca(tarea);
    }

    void imprimirTareas(){
        listaTareas.imprimirLista();
    }

    

}
