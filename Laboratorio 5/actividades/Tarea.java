package actividades;

public class Tarea {
    private String titulo;
    private int prioridad;
    private String descripcion;

    public Tarea(String titulo, int prioridad, String descripcion){
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
    }

    //Getters y Setters
    public String getTitulo() {
        return titulo;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public String getDescripcion() {
        return descripcion;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
