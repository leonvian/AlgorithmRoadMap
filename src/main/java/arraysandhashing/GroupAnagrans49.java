package arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrans49 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //String[] myStrings = { "eat","tea","tan","ate","nat","bat" };
        String[] myStrings =  {"bdddddddddd","bbbbbbbbbbc"};
        List<List<String>> result = solution.groupAnagrams(myStrings);
        StringBuilder sb = new StringBuilder();
        for (List<String> currentList : result) {
            sb.append(" - ");
            sb.append("{");
            for (String currentStr : currentList) {
                sb.append(currentStr);
                sb.append(" ");
            }
            sb.append("}");
        }

        System.out.println(sb);
    }

    public static class Solution {

        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> data = new HashMap();
            for (String target : strs) {
                String identifier = createIdentifier(target);

                List<String> list = null;
                if (data.containsKey(identifier)) {
                    list =  data.get(identifier);
                } else {
                    list = new ArrayList<String>();
                }

                list.add(target);
                data.put(identifier, list);
            }

            List<List<String>> result = new ArrayList<List<String>>();
            for (String key :  data.keySet()) {
                List<String> currentList = new ArrayList<String>();
                currentList.addAll(data.get(key));
                result.add(currentList);
            }

            return result;
        }

        private String createIdentifier(String target) {
            int[] array = new int[26];

            char[] arrayTarget = target.toCharArray();
            for (char currentChar : arrayTarget) {
                int pos = (int) currentChar  - (int) 'a';
                array[pos] = array[pos] + 1;
            }

            StringBuilder sb = new StringBuilder();
            for (int value : array) {
                sb.append("-");
                sb.append(value);
            }

            return sb.toString();
        }
    }
}

