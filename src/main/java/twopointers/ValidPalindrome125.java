package twopointers;

import java.util.HashMap;

public class ValidPalindrome125 {

    public static void main(String[] args) {
        boolean result = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);

        isPalindromeFinal("race a car");
    }


    public static boolean isPalindromeFinal(String newStr) {
        HashMap<Character, Character> lowerCase = buildLowerCaseHashMap();
        int low = 0;
        int end = newStr.length()-1;
        while (low < end) {
            char lowChar = newStr.charAt(low);
            if (lowerCase.containsKey(lowChar)) {
                lowChar = lowerCase.get(lowChar);
            }

            if (isSpecialChar(lowChar)) {
                low ++;
                continue;
            }

            char endChar = newStr.charAt(end);
            if (lowerCase.containsKey(endChar)) {
                endChar = lowerCase.get(endChar);
            }

            if (isSpecialChar(endChar)) {
                end --;
                continue;
            }

            if (lowChar == endChar) {
                low ++;
                end --;
            } else {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String target) {
        HashMap<Character, Character> lowerCase = buildLowerCaseHashMap();
        StringBuilder sb = new StringBuilder();
        char[] array = target.toCharArray();
        for (char value : array) {
            if (lowerCase.containsKey(value)) {
                value = lowerCase.get(value);
            }

            if (isSpecialChar(value)) {
                continue;
            }

            sb.append(value);
        }

        String newStr = sb.toString();
        int low = 0;
        int end = newStr.length() - 1;
        while (low < end) {
            if (newStr.charAt(low) == newStr.charAt(end)) {
                low++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isSpecialChar(char target) {
        if ( target == '0' || target == '1' || target == '2' || target == '3' ||
             target == '4' || target == '5' || target == '6' || target == '7' ||
             target == '8' || target == '9') {
            return false;
        }

        int ascTableValue = (int) target - (int) 'a';
        return ascTableValue < 0 || ascTableValue > 25;
    }

    private static HashMap<Character, Character> buildLowerCaseHashMap() {
        HashMap<Character, Character> lowerCase = new HashMap<Character, Character>();

        lowerCase.put('A', 'a');
        lowerCase.put('B', 'b');
        lowerCase.put('C', 'c');
        lowerCase.put('D', 'd');
        lowerCase.put('E', 'e');
        lowerCase.put('F', 'f');
        lowerCase.put('G', 'g');
        lowerCase.put('H', 'h');
        lowerCase.put('I', 'i');
        lowerCase.put('J', 'j');
        lowerCase.put('K', 'k');
        lowerCase.put('L', 'l');
        lowerCase.put('M', 'm');
        lowerCase.put('N', 'n');
        lowerCase.put('O', 'o');
        lowerCase.put('P', 'p');
        lowerCase.put('Q', 'q');
        lowerCase.put('R', 'r');
        lowerCase.put('S', 's');
        lowerCase.put('T', 't');
        lowerCase.put('U', 'u');
        lowerCase.put('V', 'v');
        lowerCase.put('X', 'x');
        lowerCase.put('Z', 'z');
        lowerCase.put('W', 'w');
        lowerCase.put('Y', 'y');

        return lowerCase;
    }
}
