package graph;

public class zEdgeObj<V,E> {
    protected E info;
    protected zVertexObj<V,E> endVertex1;
    protected zVertexObj<V,E> endVertex2;
    protected int position;

    public zEdgeObj(zVertexObj<V,E> vert1, zVertexObj<V,E> vert2, E info,int position){
        this.endVertex1 = vert1;
        this.endVertex2 = vert2;
        this.info = info;
        this.position = position;
    }
}
