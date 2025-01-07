package binarysearch;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity
 */
public class SearchInRotatedArray {

    public static void main(String[] args) {
        // [4,5,6,7,0,1,2], target = 0
        //System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0));
        //System.out.println(search(new int[] {1,3}, 3));
        System.out.println(search(new int[] {3,5,1}, 1));

    }

    public static int search(int[] nums, int target) {
        int rotatePoint = searchRotatePoint(nums, target);
        if (rotatePoint == -1) {
            return rec(nums, 0, nums.length -1, target);
        }
        if (target >= nums[0] && target <= nums[rotatePoint]) {
            return rec(nums, 0, rotatePoint, target);
        } else {
           return rec(nums, rotatePoint +1, nums.length - 1, target);
        }
    }

    private static int rec(int[] nums, int start, int end, int target) {
        if (start > end) return -1;

        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;

        // 1 2 3 4 5 = 4
        if (target < nums[mid]) {
            end = mid -1;
        } else {
            start = mid +1;
        }

        return rec(nums, start, end, target);
    }

    private static int searchRotatePoint(int[] nums, int target) {
        if (nums[0] < nums[nums.length -1]) return -1; // Array is not rotated
        if (nums.length == 2) return 1;
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid > 0 && nums[mid] < nums[mid -1]) return mid;
            if (mid +1 < nums.length && nums[mid] > nums[mid +1]) return mid;

            if (nums[start] < nums[mid]) {
                start = mid +1;
            } else {
                end = mid -1;
            }
        }

        return -1;
    }
}
