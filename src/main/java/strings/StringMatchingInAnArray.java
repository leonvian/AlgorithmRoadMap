package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringMatchingInAnArray {


    public static void main(String[] args) {
        List<String> res = stringMatching(new String[]{"leetcode", "et", "code"});
        for (String ans : res) {
            System.out.println(ans);
        }


    }


    public static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < words.length; i ++) {
            for (int j = 0; j < words.length; j ++) {
                if (i == j) {
                    continue;
                }

                if (isSub(words[i], words[j])) {
                    ans.add(words[i]);
                }
            }
        }

        return ans;
    }

    private static boolean isSub(String a, String b) {
        if (a.length() > b.length()) return false;


        for (int i = 0; i < b.length(); i ++) {
            if (a.charAt(0) == b.charAt(i)) {
                int j = 0;
                int m = i;
                while (a.charAt(j) == b.charAt(m)) {
                    j++;
                    m++;
                    if (j == a.length()) return true;
                    if (m == b.length()) break;
                }
            }


        }
        return false;
    }
}
