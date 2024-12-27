package math;

import java.util.HashSet;

public class IsHappy {

    public static void main(String[] args) {
        isHappy(19, new HashSet());
    }

    public static boolean isHappy(int n, HashSet<Integer> unique) {
        if (unique.contains(n)) return false;
        if (n == 1) return true;

        unique.add(n);

        int res = calcSquare(n);
        return isHappy(res, unique);
    }

    private static int calcSquare(int n) {
        String value = String.valueOf(n);
        int sum = 0;
        for (char c : value.toCharArray()) {
            int current = Character.getNumericValue(c);
            sum += current * current;
        }

        return sum;
    }
}
