package Lab8;

public class NodeAVL<E extends Comparable<E>> {
    protected E data;
    protected int bf; // balance factor
    protected NodeAVL<E> left, right;

    public NodeAVL(E data) {
        this.data = data;
        this.bf = 0;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return data + " (bf=" + bf + ")";
    }
}
