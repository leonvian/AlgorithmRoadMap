package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Given an integer array nums of unique elements, return all possible
 * subsets
 *  (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class Subset2 {

    public static void main(String[] args) {
        findDifferentBinaryString(new String[] {"001", "010","100","111", "011"});

    }

    public static String findDifferentBinaryString(String[] nums) {
        HashSet<String> data = new HashSet<String>();
        for (String num : nums) {
            data.add(num);
        }

        String result = buildString(new StringBuilder(), '0', 3, data);
        if (result != null) {
            return result;
        }

        result = buildString(new StringBuilder(), '1', 3, data);
        return result;
    }



    private static String buildString(StringBuilder sb, char nextChar, int size, HashSet<String> data) {
        sb.append(nextChar);
        if (sb.length() == size) {
            if (!data.contains(sb.toString())) {
                return sb.toString();
            }
        } else {
            String result =  buildString(new StringBuilder(sb), '1', size, data);
            if (result != null) {
                return result;
            }

            return buildString(new StringBuilder(sb), '0', size, data);
        }

        return null;
    }

}
