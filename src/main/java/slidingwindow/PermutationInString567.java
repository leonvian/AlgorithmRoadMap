package slidingwindow;

import java.util.HashMap;

public class PermutationInString567 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
       // System.out.println(checkInclusion("adc", "dcda"));
       // System.out.println(checkInclusion("ab", "eidboaoo"));

    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] data = new int[26];
        for (char current : s1.toCharArray()) {
            int pos =  current - 'a';
            data[pos] = data[pos] + 1;
        }

        int left = 0;
        int right = 0;

        int[] target = new int[26];
        for (; right < s1.length(); right ++) {
            int pos =  s2.charAt(right) - 'a';
            target[pos] = target[pos] + 1;
        }

        if (check(data, target)) {
            return true;
        }

        while (right < s2.length()) {
            int posLeft = s2.charAt(left) - 'a';
            target[posLeft] = target[posLeft] - 1;

            int posRight = s2.charAt(right) - 'a';
            target[posRight] = target[posRight] + 1;

            if (check(data, target)) {
                return true;
            }
            right ++;
            left ++;
        }

        return false;
    }

    private static boolean check(int[] data, int[] target) {
        for (int i = 0; i < data.length; i ++) {
            if (data[i] != target[i]) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkWindow(HashMap<Character, Integer> data, String target, int left) {
        while (left < target.length()) {
            char current = target.charAt(left);
            if (data.isEmpty()) {
                return true;
            }

            if (!data.containsKey(current)) {
                return false;
            }

            int count = data.get(current);
            if (count == 1) {
                data.remove(current);
            } else {
                data.put(current, data.get(current) - 1);
            }

            left++;
        }

        return true;
    }

    public static void loadData(String s1, HashMap<Character, Integer> data) {
        for (char current : s1.toCharArray()) {
            if (data.containsKey(current)) {
                data.put(current, data.get(current) + 1);
            } else {
                data.put(current, 1);
            }
        }
    }

}
