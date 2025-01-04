package strings;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueLength3PalindromicSubsequences {

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }

    public static int countPalindromicSubsequence(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = s.length() -1; i >= 0 ; i --) {
            if (map.containsKey(s.charAt(i)))
                continue;

            map.put(s.charAt(i), i);
        }

        HashSet<String> res = new HashSet();
        for (int i = 0; i < s.length(); i ++) {
            char start = s.charAt(i);

            if (!map.containsKey(start))
                continue;

            int end = map.get(start);
            int finalEnd = end;
            while(end > i +1) {
                end --;
                String str = ""+ start+ s.charAt(end) + s.charAt(finalEnd);
                res.add(str);
            }

            map.remove(start);
        }

        return res.size();
    }


}
