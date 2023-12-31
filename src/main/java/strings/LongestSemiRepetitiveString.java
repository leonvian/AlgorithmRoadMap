package strings;

public class LongestSemiRepetitiveString {

    public static void main(String[] args) {
        int max = longestSemiRepetitiveSubstring("1111111");
        System.out.println(max);
    }

    private static int longestSemiRepetitiveSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int endFirstConsecutive = -1;
        int start = 0;
        int max = 0;

        for (int i = 1; i < s.length(); i ++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                if (endFirstConsecutive != -1) {
                    start = endFirstConsecutive;
                }
                endFirstConsecutive = i;
            }

            max = Math.max(max, i - start + 1);
        }

        return max;
    }
}
