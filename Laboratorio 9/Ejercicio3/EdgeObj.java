package Ejercicio3;

public class EdgeObj<V, E> {
    protected E info;
    protected VertexObj<V, E> vertice1;
    protected VertexObj<V, E> vertice2;
    protected int posicion;

    public EdgeObj(VertexObj<V, E> vert1, VertexObj<V, E> vert2, E info, int posicion) {
        this.vertice1 = vert1;
        this.vertice2 = vert2;
        this.info = info;
        this.posicion = posicion;
    }

    public VertexObj<V, E> obtenerVertice1() {
        return vertice1;
    }

    public VertexObj<V, E> obtenerVertice2() {
        return vertice2;
    }

    public String toString() {
        return "(" + vertice1 + " - " + vertice2 + ")";
    }
}
