package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {


    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits.isEmpty()) return result;
        HashMap<Character, String> data = new HashMap();
        data.put('2', "abc");
        data.put('3', "def");
        data.put('4', "ghi");
        data.put('5', "jkl");
        data.put('6', "mno");
        data.put('7', "qprs");
        data.put('8', "tuv");
        data.put('9', "wxyz");


        backtrack(0,"", data, digits, result);

        return result;
    }

    private static void backtrack(
            int i,
            String current,
            HashMap<Character, String> data,
            String digits,
            List<String> result) {
        if (current.length() == digits.length()) {
            result.add(current);
            return;
        }

        for (Character currentC : data.get(digits.charAt(i)).toCharArray()) {
            backtrack(i + 1, current + currentC, data, digits, result);
        }
    }

}
