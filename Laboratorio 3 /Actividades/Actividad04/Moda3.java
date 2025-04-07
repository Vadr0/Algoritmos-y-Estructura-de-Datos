package Actividad04;


import java.util.*;

class Limits {
    int[] a;
    int prim;
    int ult;
    
    public Limits(int[] a, int prim, int ult) {
        this.a = a;
        this.prim = prim;
        this.ult = ult;
    }
    
    public int length() {
        return ult - prim + 1;
    }
}

class SetVectors {
    private TreeSet<Limits> set;
    
    public SetVectors() {
        set = new TreeSet<>(Comparator.comparingInt(Limits::length).reversed());
    }
    
    public void insertar(Limits p) {
        if (p.prim < p.ult) {
            set.add(p);
        }
    }
    
    public int longMayor() {
        if (set.isEmpty()) return 0;
        return set.first().length();
    }
    
    public Limits mayor() {
        Limits p = set.first();
        set.remove(p);
        return p;
    }
    
    public boolean esVacio() {
        return set.isEmpty();
    }
    
    public void destruir() {
        set.clear();
    }
}

public class Moda3 {
    
    public static int moda3(int[] a, int prim, int ult) {
        SetVectors heterogeneo = new SetVectors();
        SetVectors homogeneo = new SetVectors();
        
        Limits p = new Limits(a, prim, ult);
        heterogeneo.insertar(p);
        
        while (heterogeneo.longMayor() > homogeneo.longMayor()) {
            p = heterogeneo.mayor();
            
            // Calculamos la mediana de p
            int mediana = p.a[(p.prim + p.ult) / 2];
            
            // Dividimos p en 3 subvectores
            int[] izqDer = new int[2];
            pivote2(p.a, mediana, p.prim, p.ult, izqDer);
            int izq = izqDer[0];
            int der = izqDer[1];
            
            Limits p1 = new Limits(p.a, p.prim, izq - 1);
            Limits p2 = new Limits(p.a, izq, der - 1);
            Limits p3 = new Limits(p.a, der, p.ult);
            
            // Modificamos los conjuntos heterog y homog
            heterogeneo.insertar(p1);
            heterogeneo.insertar(p3);
            homogeneo.insertar(p2);
        }
        
        if (homogeneo.esVacio()) {
            return a[prim];
        }
        
        p = homogeneo.mayor();
        homogeneo.destruir();
        heterogeneo.destruir();
        return p.a[p.prim];
    }
    
    private static void pivote2(int[] a, int mediana, int prim, int ult, int[] izqDer) {
        int i = prim;
        int j = prim;
        int k = ult;
        
        while (j <= k) {
            if (a[j] < mediana) {
                swap(a, i, j);
                i++;
                j++;
            } else if (a[j] == mediana) {
                j++;
            } else {
                swap(a, j, k);
                k--;
            }
        }
        
        izqDer[0] = i;
        izqDer[1] = j;
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        int moda = moda3(arr, 0, arr.length - 1);
        System.out.println("La moda es: " + moda);
    }
}