package math;

public class MinimumBallsInBag {


    public static void main(String[] args) {
        System.out.println(minimumSize(new int[] {7}, 2));
    }


    private static int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for (int value : nums) {
            max = Math.max(max, value);
        }

        int low = 1;
        int high = max;

        int result = max;
        while (low <= high) {
            int mid =  (high + low) / 2;
            if (canSplitToAchieveThis(mid, maxOperations, nums)) {
                result = mid;
                high = mid -1;
            } else {
                low = mid +1;
            }
        }

        return result;
    }

    private static boolean canSplitToAchieveThis(int target, int maxOperations, int[] nums) {
        int ops = 0;
        for (int value : nums) {
            ops += Math.ceil((float)value / (float)target) - 1;
            if (ops > maxOperations)
                return false;
        }

        return true;
    }


}
