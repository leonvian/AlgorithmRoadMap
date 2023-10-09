package stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses20 {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); // ()
        for (char target : s.toCharArray()) {
            if (target == '(' || target == '{' || target == '[') {
                stack.push(target);
            } else {

                if (target == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }

                if (target == '}') {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }

                if (target == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }

            }
        }

        return stack.isEmpty();
    }
}
