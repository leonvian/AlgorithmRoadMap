package arraysandhashing;

public class RotateArray {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        nums = rotate(nums, 2);

        System.out.println(12 % 2);
        System.out.println(13 % 2);

        for (int num : nums) {
            System.out.print(num);
            System.out.print(" - ");
        }
    }

    private static int[] rotate(int[] nums, int k) {
        if (nums.length <= 1) return nums;

        int[] copy = new int[nums.length];

        int rotate = k % nums.length;
        for (int i = 0; i < nums.length; i ++) {
            int newPos = (i + rotate) % nums.length;
            copy[newPos] = nums[i];
        }

       return copy;
    }
}
