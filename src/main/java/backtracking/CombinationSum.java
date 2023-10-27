package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * OnGOING
 *
 * https://leetcode.com/problems/combination-sum/
 *
 * LeetCode 39 Combination sum
 */
public class CombinationSum {

    public static void main(String[] args) {
        combinationSum(new int[]{2,3,5}, 8);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalResult = new ArrayList<List<Integer>>();

        HashMap<Integer, List<List<Integer>>> data = new HashMap();

        for (int value : candidates) {
            if (value == target) {
                List<Integer> singleResult = new ArrayList<Integer>();
                singleResult.add(value);
                finalResult.add(singleResult);
                continue;
            }
            int times = 1;
            int sum = value;
            while (sum < target) {
                if (data.containsKey(sum)) {
                    List<List<Integer>> clone = new ArrayList<>();
                    for (List<Integer> originals : data.get(sum)) {
                        clone.add(new ArrayList<Integer>(originals));
                    }
                    for (List<Integer> result : clone) {
                        for (int i = 0; i < times; i ++) {
                            result.add(value);
                        }
                        finalResult.add(result);
                    }
                }
               // data.remove(sum);

                int futureMatch = target - sum;
                List<Integer> result = new ArrayList();
                for (int i = 0; i < times; i ++) {
                    result.add(value);
                }
                List<List<Integer>> matches = new ArrayList<List<Integer>>();
                if (data.containsKey(futureMatch)) {
                    matches = data.get(futureMatch);
                }
                matches.add(result);
                data.put(futureMatch, matches);
                times ++;
                sum = value * times;
            }

        }

        return finalResult;
    }

}
