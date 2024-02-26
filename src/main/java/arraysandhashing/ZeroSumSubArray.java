package arraysandhashing;

import java.util.HashSet;

public class ZeroSumSubArray {

    public static void main(String[] args) {
        System.out.println(zeroSumSubarray(new int[]{1, 2, 3}));
    }

    private static boolean zeroSumSubarray(int[] nums) {
        HashSet<Integer> data = new HashSet<Integer>();
        data.add(0);
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (data.contains(currentSum))
                return true;
            data.add(currentSum);
        }

        return false;
    }
}
