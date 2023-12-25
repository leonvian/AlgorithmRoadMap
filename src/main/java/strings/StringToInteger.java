package strings;

import java.util.LinkedList;

public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(isPalindrome(131));
        System.out.println(isPalindrome(1331));
        System.out.println(isPalindrome(133123));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x <= 9) return true;

        LinkedList<Integer> linkedList = new LinkedList<>();

        while (x > 0) {
            int lastDigit = x % 10;
            linkedList.add(lastDigit);
            x = x / 10;
        }

        while (linkedList.size() > 1) {
            if (linkedList.pollFirst() != linkedList.pollLast()) {
                return false;
            }
        }
        return true;
    }
}
