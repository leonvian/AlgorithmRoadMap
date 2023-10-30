package slidingwindow;

import java.util.HashMap;

public class MinWindow {

    /**
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     *
     */

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "BANC"));
    }

    public static String minWindow(String text, String target) {
        if (target.length() > text.length()) return "";

        HashMap<Character, Integer> data = new HashMap<>();
        loadData(text, data);

        HashMap<Character, Integer> patternData = new HashMap<>();
        loadData(target, patternData);

        if (isValid(data, patternData)) {
            String minLeft = minWindowLeft(0, text.length(),data, patternData, target, text);
            String minRight = minWindowRight(0, text.length(),data, patternData, target, text);
            String minBoth = minWindowBoth(0, text.length(),data, patternData, target, text);

            if (minLeft.length() < minRight.length()) {
                if (minLeft.length() < minBoth.length()) {
                    return minLeft;
                } else {
                    return minBoth;
                }
            } else {
                if (minRight.length() < minBoth.length()) {
                    return minRight;
                } else {
                    return minBoth;
                }
            }
        } else {
            return "";
        }
    }

    private static String minWindowLeft(
            int left,
            int right,
            HashMap<Character, Integer> data,
            HashMap<Character, Integer> patternData,
            String pattern,
            String text) {
        int windowSize = right - left;
        if (windowSize < pattern.length()) return text.substring(left -1, right);
        if (!isValid(data, patternData)) return text.substring(left -1, right);


        countDownFromData(text.charAt(left), data);
        return minWindowLeft(
                left +1,
                right,
                data,
                patternData,
                pattern,
                text
        );
    }

    private static String minWindowRight(
            int left,
            int right,
            HashMap<Character, Integer> data,
            HashMap<Character, Integer> patternData,
            String pattern,
            String text) {
        int windowSize = right - left;
        if (windowSize < pattern.length()) return text.substring(left, right +1);
        if (!isValid(data, patternData)) return text.substring(left, right +1);


        countDownFromData(text.charAt(left), data);
        return minWindowRight(
                left,
                right -1,
                data,
                patternData,
                pattern,
                text
        );
    }

    private static String minWindowBoth(
            int left,
            int right,
            HashMap<Character, Integer> data,
            HashMap<Character, Integer> patternData,
            String pattern,
            String text) {
        int windowSize = right - left;
        if (windowSize < pattern.length()) return text.substring(left -1, right +1);
        if (!isValid(data, patternData)) return text.substring(left -1, right +1);


        countDownFromData(text.charAt(left), data);
        return minWindowBoth(
                left +1,
                right -1,
                data,
                patternData,
                pattern,
                text
        );
    }

    private static void countDownFromData(Character key, HashMap<Character, Integer> data) {
        int count = data.get(key);
        if (count == 1) {
            data.remove(key);
        } else {
            data.put(key, count -1);
        }
    }

    private static boolean isValid(HashMap<Character, Integer> data, HashMap<Character, Integer> patternData) {
        for (Character key : patternData.keySet()) {
            if (!data.containsKey(key)) return false;

            if (data.get(key) < patternData.get(key)) return false;
        }

        return true;
    }

    private static void loadData(String text, HashMap<Character, Integer> data) {
        for (char current : text.toCharArray()) {
            int count = 0;
            if (data.containsKey(current)) {
                count = data.get(current);
            }
            count ++;
            data.put(current, count);
        }
    }

}
