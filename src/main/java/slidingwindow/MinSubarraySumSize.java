package slidingwindow;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
public class MinSubarraySumSize {

    public static void main(String[] args) {

        System.out.println(
                minSubArrayLen(7, new int[]{2,3,1,2,4,3})
        );

        System.out.println(
                minSubArrayLen( 11, new int[]{1,1,1,1,1,1,1,1})
        );
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;
        int right = 0;
        for (; right < nums.length; right ++) {
            currentSum += nums[right];

            while (currentSum >= target && left <= right) {
                minLength = Math.min(right - left + 1, minLength);
                currentSum = currentSum - nums[left];
                left ++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLength;
        }

    }
}
