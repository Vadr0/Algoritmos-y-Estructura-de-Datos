package Ejercicio 3;

public void bfs() {
    int h = height((NodeAVL<E>) root);
    for (int i = 1; i <= h; i++) {
        printLevel((NodeAVL<E>) root, i);
    }
}
