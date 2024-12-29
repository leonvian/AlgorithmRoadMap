package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        back(0,0, n, new LinkedList<Character>(), ans);
        return ans;
    }

    private static void back(int open, int close, int n, LinkedList<Character> current, List<String> ans) {
        if (current.size() == n * 2) {
            StringBuilder sb = new StringBuilder();
            for (char c : current) {
                sb.append(c);
            }
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            current.add('(');
            back(open + 1, close, n, current, ans);
            current.removeLast();
        }

        if (open > close) {
            current.add(')');
            back(open, close +1,  n, current, ans);
            current.removeLast();
        }
    }

}
