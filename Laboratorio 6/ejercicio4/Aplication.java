package ejercicio4;

import ejercicio1.StackLink;
import exceptions.ExceptionIsEmpty;

public class Aplication {

    public static boolean symbolBalancing(String s) {
    StackLink<Character> stack = new StackLink<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else if (c == ')' || c == ']' || c == '}') {
            try {
                char top = stack.pop();
                if (!matches(top, c)) return false;
            } catch (ExceptionIsEmpty e) {
                return false;
            }
        }
    }

    return stack.isEmpty();
}

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
