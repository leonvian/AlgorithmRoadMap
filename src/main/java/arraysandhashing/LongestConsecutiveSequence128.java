package arraysandhashing;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * The hint here is to find the last element of a sequence.
 *
 */
public class LongestConsecutiveSequence128 {

    public static void main(String[] args) {
        int[] nums = new int[] { 100,4,200,1,3,2 };
        Solution solution = new Solution();
        solution.longestConsecutive(nums);
    }

    public static class Solution {
        public int longestConsecutive(int[] nums) {
            HashSet<Integer> data = new HashSet<>();
            for (int value : nums) {
                data.add(value);
            }
            int max = 0;
            for (int value : data) {
                boolean isLast = !data.contains(value -1);
                if (isLast) {
                    int count = 1;
                    value ++;
                    while (data.contains(value)) {
                        count ++;
                        value ++;
                    }

                    if (count > max) {
                        max = count;
                    }
                }

            }


            return max;
        }

    }

}
