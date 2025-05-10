package ejercicio4;

public class Test {
    public static void main(String[] args) {
        System.out.println(Aplication.symbolBalancing("()()()[()]()")); // true
        System.out.println(Aplication.symbolBalancing("((()))[]"));     // true
        System.out.println(Aplication.symbolBalancing("([])[]("));      // false
        System.out.println(Aplication.symbolBalancing("([{)]}"));       // false
        System.out.println(Aplication.symbolBalancing("["));            // false
        System.out.println(Aplication.symbolBalancing("[][][]{{{}}}")); // true
    }
}
