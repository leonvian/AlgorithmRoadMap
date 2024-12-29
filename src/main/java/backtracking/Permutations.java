package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        List<List<Integer>>  result = permute(new int[] {1,2,3});
        for (List<Integer> res : result) {
            for (int value : res) {
                System.out.print(value);
                System.out.print(",");
            }
            System.out.println("");
        }



    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        add(result, new LinkedList<Integer>(), nums);

        return result;
    }

    private static void add(List<List<Integer>> ans, LinkedList<Integer> sol, int[] nums) {
        if (sol.size() == nums.length) {
            ans.add(new ArrayList<Integer>(sol));
            return;
        }

        for (int num : nums) {
            if (!sol.contains(num)) {
                sol.push(num);
                add(ans, sol, nums);
                sol.poll();
            }
        }

    }

}
