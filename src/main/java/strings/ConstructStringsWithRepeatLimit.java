package strings;

import java.util.Arrays;
import java.util.Collections;

public class ConstructStringsWithRepeatLimit {


    public static void main(String[] args) {
        //System.out.println(buildString2("cczazcc", 3));
    //    System.out.println(buildString2("aababab", 2));
//zzcccac
        //pdprlxqryxdirdr
        System.out.println(buildString2("pdprlxqryxdirdr", 10));
    }

    private static String buildString2(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char current : s.toCharArray()) {
            freq[current - 'a'] = freq[current - 'a'] + 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i --) {
            if (freq[i] == 0) continue;

            if (freq[i] <= repeatLimit) {
                int currentFrequency = freq[i];
                for (int j = 0; j <= currentFrequency; j ++) {
                    sb.append(toChar(i));
                    freq[i] = freq[i] -1;
                }
            } else {
                while (freq[i] > 0) {
                    int limit = Math.min(freq[i],repeatLimit);
                    for (int j = 0; j < limit; j ++) {
                        sb.append(toChar(i));
                        freq[i] = freq[i] -1;
                    }
                    if (freq[i] != 0) {
                        for (int j = i -1; j >= -1; j --) {
                            if (j == -1) return sb.toString();
                            if (freq[j] == 0) continue;

                            sb.append(toChar(j));
                            freq[j] = freq[j] -1;
                            break;
                        }
                    }
                }
            }
        }

        String result = sb.toString();
        return result;
    }

    private static char toChar(int value) {
        return (char)(value + 'a');
    }


    /* Solution 1 too slow */
    private static String buildString(String s, int repeatLimit) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        reverse(array);

        int limit = 1;
        for (int i = 1; i < array.length; i ++) {
            if (array[i] == array[i -1]) {
                limit ++;
                if (limit > repeatLimit) {
                    int j = i;
                    while (j < s.length() && array[j] == array[i]) {
                        j++;
                    }
                    if (j == s.length()) {
                        return toString(array, i);
                    } else {
                        swap(array, i, j);
                        limit = 1;
                    }
                }
            } else {
                limit = 1;
            }
        }

        return new String(array);
    }

    private static void reverse(char[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            swap(array, start, end);
            start ++;
            end --;
        }
    }

    private static String toString(char[] array, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < end; i ++) {
            sb.append(array[i]);
        }

        return sb.toString();
    }

    private static void swap(char[] array, int start, int end) {
        char tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }

}
