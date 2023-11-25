package strings;

public class LongestPalindromicString {

    public static void main(String[] args) {
        String longest = longestPalindrome("cbbd");
        System.out.println(longest);
    }

    public static String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int maxRange = 0;
        int[] bestRange = null;
        for (int i = 0; i < array.length; i++) {
            int[] range = getOddPalindromeSize(array, i, i);
            int currentSize = range[1] - range[0];
            if (currentSize >= maxRange) {
                bestRange = range;
                maxRange = currentSize;
            }

            range = getOddPalindromeSize(array, i, i+1);
            if (range == null) continue;
            currentSize = range[1] - range[0];
            if (currentSize > maxRange) {
                bestRange = range;
                maxRange = currentSize;
            }
        }

        String result = s.substring(bestRange[0], bestRange[1] + 1);
        return result;
    }

    private static int[] getOddPalindromeSize(char[] array, int left, int right) {
        int[] result = null;
        while (left >= 0 && right <= array.length - 1 && array[left] == array[right]) {
            result = new int[2];
            result[0] = left;
            result[1] = right;
            left--;
            right++;
        }

        return result;
    }

}
