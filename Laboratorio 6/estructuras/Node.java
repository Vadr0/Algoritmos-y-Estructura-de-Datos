package estructuras;

public class Node<T>{
    public T data;
    public Node<T> nextNode;

    //Constructor
    public Node(T dato){
        this.data = dato;
        this.nextNode = null;
    }
}