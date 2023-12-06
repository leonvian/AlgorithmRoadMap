package binarysearch;

/**
 * https://leetcode.com/problems/binary-search/description/
 */
public class BinarySearch704 {

    public static void main(String[] args) {

    }

    public static int search(int[] nums, int target) {


       int left = 0;
       int right = nums.length -1;

       while (left < right) {
           int mid = (left + right) / 2;

           if (nums[mid] == target) {
               return mid;
           }

           if (nums[mid] > target) {
               right = mid -1;
           } else{
               left = mid +1;
           }
       }

       return -1;
    }
}
