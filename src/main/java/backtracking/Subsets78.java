package backtracking;

import java.util.*;

public class Subsets78 {


    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public List<List<Integer>> subsets(int[] nums) {
        

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        addSubset(nums, 0, result, new LinkedList<Integer>());

        return result;
    }


    private void addSubset(int[] nums, int i, List<List<Integer>> result, LinkedList<Integer> subset) {
        if (i >= nums.length) {
            result.add(new ArrayList<Integer>(subset));
            return;
        }

        subset.push(nums[i]);
        addSubset(nums, i + 1, result, subset);

        subset.pop();
        addSubset(nums, i + 1, result, subset);
    }

}
