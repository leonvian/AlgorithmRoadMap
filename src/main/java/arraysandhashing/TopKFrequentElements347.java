package arraysandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class TopKFrequentElements347 {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.topKFrequent(new int[] {1,1,1,2,2,3}, 2);
        System.out.println(" " + result[0] + " " +result[1]);
    }

    /**
     * Bucket sort solution when you use the indexes of array to map the data.
     * In this case the array index will represent the counter of a number
     * and the value will ALL  the numbers that contains those amount.
     */
    public static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> data = new HashMap();

            for (int num : nums) {
                if (data.containsKey(num)) {
                    int counter = data.get(num) + 1;
                    data.put(num, counter);
                } else {
                    data.put(num, 1);
                }
            }

            LinkedList<Integer>[] array = new LinkedList[nums.length + 1];
            for (int i  = 0; i < array.length; i ++) {
                array[i] = new LinkedList<Integer>();
            }

            for (int key : data.keySet()) {
                int count = data.get(key);
                array[count].add(key);
            }

            int end = array.length - 1;
            int[] result = new int[k];
            int i = 0;
            while (k != 0) {
                while (!array[end].isEmpty()) {
                    result[i] = array[end].pop();
                    i ++;
                    k --;
                }
                end --;
            }

            return result;
        }
    }


}
