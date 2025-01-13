package slidingwindow;

import utils.Checker;

public class SlindingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        Checker.printArray(ans);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k >= nums.length) return nums;

        int sum = 0;
        for (int i = 0; i < k; i ++) {
            sum += nums[i];
        }

        int[] ans = new int[nums.length - k + 1];
        ans[0] = sum;
        int max = sum;
        int start = 0;

        for (int end = k; end < nums.length; end ++) {
            sum -= nums[start];
            start ++;
            sum += nums[end];

            max = Math.max(sum, max);
            max = Math.max(max, nums[end]);
            ans[start] = max;
        }

        return ans;
    }
}
