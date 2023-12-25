package recursion;

/**
 *
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */
public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("112112"));
    }

    private static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() +1];
        dp[s.length()] = 1;

        return decode(dp, s.toCharArray(), 0);
    }

    private static int decode(int[] dp, char[] array, int pos) {
        System.out.println("Pos " + pos);
        if (dp[pos] != 0) return dp[pos];

        if (pos > array.length -1) return 1;

        if (array[pos] == '0') return 0;

        int result = decode(dp, array, pos +1);

        if (pos + 1 <= array.length -1 && array[pos] != '0' && toInt(array, pos, pos +1) <= 26) {
            result += decode(dp, array, pos +2);
        }

        dp[pos] = result;

        return result;
    }

    private static int toInt(char[] array, int i, int j) {
        String target = ""+array[i] +array[i+1];
        return Integer.valueOf(target);
    }

}
