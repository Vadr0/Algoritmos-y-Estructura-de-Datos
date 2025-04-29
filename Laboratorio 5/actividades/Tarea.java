package actividades;

public class Tarea {
    private String titulo;
    private int prioridad;
    private String descripcion;

    public Tarea(String titulo, int prioridad, String descripcion) {
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
    }

    // Getters y Setters
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
    public boolean equals(Object obj) {
        // Comprobamos si ambos objetos son el mismo
        if (this == obj) {
            return true; //Son iguales
        }

        // Si el objeto es nulo o no es del mismo tipo, no son iguales
        if (obj == null || getClass() != obj.getClass()) {
            return false; //No son iguales
        }

        //Se realiza el casting
        Tarea tarea = (Tarea) obj;

        // Comparamos los atributos principales de la tarea (nombre y prioridad)
        return prioridad == tarea.prioridad && titulo.equals(tarea.titulo);
    }

    @Override
    public String toString() {
        return titulo;
    }
}
