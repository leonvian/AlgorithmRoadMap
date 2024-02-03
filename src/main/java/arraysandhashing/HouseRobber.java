package arraysandhashing;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(dp(new int[] { 2,1,1,2}));
    }
    private static int dp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i ++) {
            dp[i] = Math.max(dp[i -1], nums[i] + get(dp, i-2));
        }

        return dp[nums.length -1];
    }

    private static int get(int[] nums, int pos) {
        if (pos < 0) return 0;

        return nums[pos];
    }

    public static int rob(int[] nums) {
        return Math.min(rob(nums, 0), rob(nums, 1));
    }

    private static int rob(int[] nums, int pos) {
        if (pos >= nums.length) return 0;

        int result =  nums[pos] + rob(nums, pos +2);
        return  result;
    }
}
