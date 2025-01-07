package strings;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aa"));
    }

    public static int countSubstrings(String s) {
        // a b c
        int count = 0;
        for (int i = 0; i < s.length(); i ++) {
            count += countPalindrome(s, i, i) + countPalindrome(s, i, i +1);
        }

        return count;
    }

    private static int countPalindrome(String target, int right, int left) {
        int count = 0;
        while (right >= 0 && left < target.length()) {
            if (target.charAt(right) != target.charAt(left)) {
                return count;
            }
            count ++;
            right --;
            left ++;
        }
        return count;
    }

    private static boolean isPalindrome(String target) {
        int start = 0;
        int end = target.length() -1;
        while (start < end) {
            if (target.charAt(start) != target.charAt(end)) return false;

            start ++;
            end --;
        }

        return true;
    }
}
