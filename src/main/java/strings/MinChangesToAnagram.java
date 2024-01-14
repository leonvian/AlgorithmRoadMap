package strings;

public class MinChangesToAnagram {

    public static void main(String[] args) {
        int steps = minSteps("leetcode", "practice");
        System.out.println(steps);
    }

    private static int minSteps(String s, String t) {
        int[] source = buildCounter(s);
        int[] target = buildCounter(t);
        int steps = 0;
        for (int i = 0; i < target.length; i ++) {
            if (target[i] > source[i]) {
                steps += target[i] - source[i];
            }
        }

        return steps;
    }

    private static int[] buildCounter(String text) {
        int[] al = new int[26];
        for (int i = 0; i < text.length(); i ++) {
            char current = text.charAt(i);
            al[current - 'a'] = al[current - 'a'] + 1;
        }
        return al;
    }

}
