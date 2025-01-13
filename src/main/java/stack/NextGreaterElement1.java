package stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {

    public static void main(String[] args) {
        nextGreaterElement(new int[] { 4,1,2 }, new int[] {1,3,4,2});
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack();
        HashMap<Integer, Integer> posMap = new HashMap();
        int[] res = new int[nums2.length];
        for (int i = nums2.length -1; i >= 0; i --) {
            posMap.put(nums2[i], i);
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = nums2[stack.peek()];
            }

            stack.push(i);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i ++) {
            int num = nums1[i];
            int pos = posMap.get(num);
            ans[i] = res[pos];
        }

        return ans;
    }
}
