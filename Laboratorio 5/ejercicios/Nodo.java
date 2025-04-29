package ejercicios;

public class Nodo<T>{
    private T dato;
    private Nodo<T> siguienteNodo;

    //Constructor
    public Nodo(T dato){
        this.dato = dato;
        this.siguienteNodo = null;
    }
    //Getters y Setters
    public T getDato() {
        return dato;
    }
    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguienteNodo() {
        return siguienteNodo;
    }
    public void setSiguienteNodo(Nodo<T> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }

}