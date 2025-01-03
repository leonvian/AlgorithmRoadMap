package prefix;

public class NumberOfWaysToSplitArray {

    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[] {10,4,-8,7,10,4,-8,7}));
        //[10, 4, -8, 7, 10, 4, -8, 7]
    }

    public static int waysToSplitArray(int[] nums) {
        long right = 0;
        for (int value : nums) {
            right += value;
        }

        long left = 0;
        int count = 0;
        for (int i = 0; i < nums.length -1; i ++) {
            int value = nums[i];
            left += value;
            right -= value;

            if (left >= right) {
                count ++;
            }
        }

        return count;
    }
}
