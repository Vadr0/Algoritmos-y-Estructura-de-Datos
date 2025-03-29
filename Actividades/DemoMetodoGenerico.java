package Actividades;

public class DemoMetodoGenerico {
    static <T extends Comparable<T>> boolean igualArrays(T[] x, T[] y) {
        //Si las longitudes de los array son diferentes, entonces los array son diferentes
        if (x.length != y.length)
            return false;
        for (int i = 0; i < x.length; i++)
            if (!x[i].equals(y[i]))
                return false; //arrays diferentes
        return true; // Contenido de arrays son equivalentes
    }

    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5};
        Integer nums2[] = {1, 2, 3, 4, 5};
        Integer nums3[] = {1, 2, 7, 4, 5};
        Integer nums4[] = {1, 2, 7, 4, 5, 6};
        if (igualArrays(nums, nums))
            System.out.println("nums es igual a nums");
        if (igualArrays(nums, nums2))
            System.out.println("nums es igual a nums2");
        if (igualArrays(nums, nums3))
            System.out.println("nums es igual a num3");
        if (igualArrays(nums, nums4))
            System.out.println("nums es igual a nums4");
/*
* Respecto a la actividad 6,el codigo no compila,
*al definir igualArrays, pusimos la restriccion T extends Comparable <T>
*por lo que ambos deberian de contener elementos del mismo tipo T que implemente comparable <T>
 * */
//AA        // Crea un array de double
//BB        Double[] dvals ={1.1,2.2,3.3,4.4,5.5};
//CC        if(igualArrays(nums,dvals))
//DD            System.out.println("nums es igual a dvals");
    }
}