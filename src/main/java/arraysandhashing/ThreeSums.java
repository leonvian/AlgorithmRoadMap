package arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[] {-1,0,1,2,-1,-4});
        for (List<Integer> data : result) {
            for (Integer value : data) {
                System.out.print(" " + value);
            }
            System.out.println(" ");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList();
        if (nums.length < 3) {
            result.add(zeroes());
            return result;
        }

        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            int currentSum = nums[left] + nums[right];
            int target = getTarget(currentSum);

            if (target > 0) {
                int i = 1;
                while (nums[right -i] >= target) {
                    if (nums[right -i] == target)
                        result.add(arrayOf(nums[right],nums[left], nums[right -i]));

                    i ++;
                }
                left ++;
            } else {
                int i = 1;
                while (nums[left +i] <= target) {
                    if (nums[left +i] == target)
                        result.add(arrayOf(nums[left],nums[right], nums[left +i]));

                    i ++;
                }
                right --;
            }
        }

        if (result.isEmpty()) {
            result.add(zeroes());
        }

        return result;
    }

    private static ArrayList<Integer> arrayOf(int... values) {
        ArrayList<Integer> data = new  ArrayList<Integer>();
        for (int value : values) {
            data.add(value);
        }
        return data;
    }

    private static int getTarget(int currentSum) {
        if (currentSum < 0) {
            return Math.abs(currentSum);
        } else {
            return -1 * currentSum;
        }
    }

    private static List<Integer> zeroes() {
        ArrayList<Integer>  list = new ArrayList();
        list.add(0);
        list.add(0);
        list.add(0);
        return list;
    }
}
