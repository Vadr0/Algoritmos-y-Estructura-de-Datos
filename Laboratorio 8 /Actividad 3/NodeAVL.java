class NodeAVL<E extends Comparable<E>> extends Node<E> {
    protected int bf; // Balance factor (-1, 0, 1)
    protected int height;
    
    public NodeAVL(E data) {
        super(data);
        this.bf = 0;
        this.height = 1; // Altura inicial de un nodo nuevo es 1
    }
    
    @Override
    public String toString() {
        return super.toString() + "(bf:" + bf + ", h:" + height + ")";
    }
}
