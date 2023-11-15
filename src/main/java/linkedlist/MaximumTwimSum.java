package linkedlist;

import java.util.Stack;

public class MaximumTwimSum {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;

        pairSum(one);
    }

    public static int pairSum(ListNode head) {
        if (head == null) return 0;

        ListNode slow = head;
        ListNode fast = head;

        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }

        int maxSum = 0;
        while (!stack.isEmpty()) {
            int currentSum = stack.pop() + slow.value;
            maxSum = Math.max(currentSum, maxSum);
            slow = slow.next;
        }

        return maxSum;
    }

}
