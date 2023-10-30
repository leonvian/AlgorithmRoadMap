package stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 * <p>
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * <p>
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));

    }

    private static int calculate(String s) {
        Stack<LinkedList<Integer>> stackNumbers = new Stack<>();
        stackNumbers.push(new LinkedList<Integer>());

        Stack<LinkedList<Character>> stackOperations = new Stack<LinkedList<Character>>();
        stackOperations.push(new LinkedList<>());

        for (char current : s.toCharArray()) {
            if (current == '(') {
                stackNumbers.push(new LinkedList<Integer>());
                stackOperations.push(new LinkedList<>());
            } else if (current == ')') {
                int sum = executeQueue(stackNumbers.pop(), stackOperations.pop());
                stackNumbers.peek().add(sum);
            } else if (current == '+' || current == '-') {
                stackOperations.peek().add(current);
            } else if (current == ' ') {
                continue;
            } else {
                stackNumbers.peek().add(Character.getNumericValue(current));
            }
        }

        int result = executeQueue(stackNumbers.pop(), stackOperations.pop());
        return result;
    }

    private static int executeQueue(LinkedList<Integer> queue, LinkedList<Character> operations) {
        if (queue.isEmpty()) return 0;
        if (operations.isEmpty()) return queue.poll();

        Integer val1 = null;
        Integer val2 = null;
        int sum = 0;

        while (!queue.isEmpty()) {
            if (val1 == null) {
                val1 = queue.poll();
            }

            val2 = queue.poll();
            Character operation = operations.poll();
            if (operation == '+') {
                sum = val1 + val2;
            } else {
                sum = val1 - val2;
            }
            val1 = sum;
        }
        return val1;
    }


}
