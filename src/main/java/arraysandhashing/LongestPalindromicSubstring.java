package arraysandhashing;

/**
 * Longest Palindromic Substring
 * The main tip here is to check if is palindrome considering the center first.
 * Keep in mind the edge case with double values on the center like: baab
 *
 * @TODO WORK IN PROGRESS
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int max = 0;
        String maxPalindrome = "";
        for(int i = 0; i < s.length(); i ++) {
            String palindrome = getPalindrome(i, s, false);
            if (palindrome.length() > max) {
                max = palindrome.length();
                maxPalindrome = palindrome;
            }

            String palindromeOdd = getPalindrome(i, s, true);
            if (palindromeOdd.length() > max) {
                max = palindromeOdd.length();
                maxPalindrome = palindromeOdd;
            }
        }

        return maxPalindrome;
    }

    private String getPalindrome(int pos, String target, boolean odd)  {
        char[] charArray = target.toCharArray();

        char current = charArray[pos];
        int left = pos;
        int right = pos;
        if (odd) {
            right ++;
        }
        while (left >= 0 && right < target.length() && charArray[left] == charArray[right]) {
            left --;
            right ++;
        }
        return target.substring(left + 1, right);
    }

    private String getPalindromeOdd(int pos, String target)  {
        char[] charArray = target.toCharArray();

        char current = charArray[pos];
        int left = pos -1;
        int right = pos +1;
        while (left >= 0 && right < target.length()) {
            if (charArray[left] != charArray[right]) {
                return target.substring(left + 1, right -1);
            } else {
                left --;
                right ++;
            }
        }
        return target.substring(left + 1, right);
    }

}
