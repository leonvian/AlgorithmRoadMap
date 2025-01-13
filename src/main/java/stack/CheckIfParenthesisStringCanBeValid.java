package stack;

import java.util.Stack;

/**
 *
 */
public class CheckIfParenthesisStringCanBeValid {

    public static void main(String[] args) {
        String s = "()", locked = "11";
        System.out.println(canBeValid(s, locked));
    }

    public static boolean canBeValid(String s, String locked) {
        char[] array = s.toCharArray();
        char[] lock = locked.toCharArray();

        Stack<Integer> open = new Stack<Integer>();
        Stack<Integer> wild = new Stack<Integer>();

        for (int i = 0; i < array.length; i ++) {
            if (lock[i] == '0') {
                wild.push(i);
                continue;
            }

            if (array[i] == '(') {
                open.push(i);
                continue;
            }

            if (array[i] == ')') {
                if (!open.isEmpty())
                    open.pop();
                else if (!wild.isEmpty())
                    wild.pop();
                else
                    return false;
            }
        }

        while (!open.isEmpty()) {
            if (wild.isEmpty()) {
                return false;
            }

            int oPos = open.pop();
            int wPos = wild.pop();
            if (oPos > wPos) {
                return false;
            }
        }

        return wild.size() % 2 == 0;
    }
}
