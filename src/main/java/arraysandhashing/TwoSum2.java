package arraysandhashing;

public class TwoSum2 {

    public static void main(String[] args) {
        int[] array = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int value : array) {
            System.out.print(value);
        }
    }

    private static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
