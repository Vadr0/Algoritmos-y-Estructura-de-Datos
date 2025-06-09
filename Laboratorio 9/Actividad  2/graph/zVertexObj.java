package graph;

public class zVertexObj<V,E>{
    protected V info;
    protected int position;

    public zVertexObj(V info, int position){
        this.info = info;
        this.position = position;
    }

    public V getInfo() {
        return info;
    }
}