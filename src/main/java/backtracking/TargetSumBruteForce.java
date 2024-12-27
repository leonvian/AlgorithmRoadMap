package backtracking;

public class TargetSumBruteForce {

    public static void main(String[] args) {


        System.out.println(0 -  1);
        findTargetSumWays(new int[] {1, 1, 1, 1 ,1}, 3);

    }

    public static int findTargetSumWays(int[] nums, int target) {
        int[] res = new int[1];
        calc(nums[0], nums, target, 0, res);
        calc(-nums[0], nums, target, 0, res);

        return res[0];
    }

    private static void calc(int sum, int[] nums, int target, int pos, int[] res) {
        if (pos == nums.length -1 && sum == target) {
            res[0] = res[0] + 1;
            return;
        }

        if (pos == nums.length - 1) {
            return;
        }

        pos ++;

        calc(sum + nums[pos], nums, target, pos, res);
        calc(sum - nums[pos], nums, target, pos, res);
    }

}
