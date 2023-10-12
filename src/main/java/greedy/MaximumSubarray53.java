package greedy;

public class MaximumSubarray53 {

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;

        int previous = nums[0];
        int max = previous;
        for (int i = 1; i < nums.length; i ++) {
            previous = Math.max((nums[i] + previous), nums[i]);
            max = Math.max(max, previous);
        }

        return max;
    }

}
