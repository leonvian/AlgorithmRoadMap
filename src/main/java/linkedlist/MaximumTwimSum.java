package linkedlist;

import java.util.Stack;

public class MaximumTwimSum {

    public static void main(String[] args) {
        ListNode one = new ListNode(5);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);

        one.next = two;
        two.next = three;
        three.next = four;

        System.out.println(pairSum(one));
    }

    public static int pairSum(ListNode head) {
        if (head == null) return 0;

        ListNode slow = head;
        ListNode fast = head;

        //Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next != null) {
            //stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode previous = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = previous;
            previous = slow;
            slow = next;
        }

        ListNode newHead = previous;
        ListNode oldHead = head;

        int maxSum = 0;
        while (newHead != null) {
           maxSum = Math.max(maxSum, newHead.value + oldHead.value);
           newHead = newHead.next;
           oldHead = oldHead.next;
        }

        /*while (!stack.isEmpty()) {
            int currentSum = stack.pop() + slow.value;
            maxSum = Math.max(currentSum, maxSum);
            slow = slow.next;
        }*/

        return maxSum;
    }

}
