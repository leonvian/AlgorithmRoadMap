package arraysandhashing;

/**
 *
 */
public class ProductOfArrayExceptSelf238 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.productExceptSelf(new int[] {1,2,3,4});
    }

    public static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] prefix = new int[nums.length];
            prefix[0] = nums[0];
            for (int i = 1; i < nums.length; i ++) {
                prefix[i] = prefix[i - 1] * nums[i];
            }

            int[] postFix = new int[nums.length];
            int endPos = nums.length-1;
            postFix[endPos] = nums[endPos];
            for (int i = endPos-1; i > 0; i --) {
                postFix[i] = postFix[i + 1] * nums[i];
            }

            for (int i = 0; i < nums.length; i ++) {
                if (i == 0) {
                    nums[i] = postFix[i+1];
                } else if (i == nums.length -1) {
                    nums[i] = prefix[i-1];
                } else {
                    nums[i] = prefix[i-1] * postFix[i+1];
                }
            }

            return nums;
        }
    }
}
