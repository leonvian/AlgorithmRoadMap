package greedy;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame55 {

    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        for (int i = target -1; i >= 0; i--) {
            int distance = target - i;
            if (nums[i] >= distance) {
                target = i;
            }
        }

        return target == 0;
    }

}
