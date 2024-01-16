package arraysandhashing;

import linkedlist.ListNode;

public class AddTwoNumbers {

    //l1 = [2,4,3], l2 = [5,6,4]
    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        //head2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(head1, head2);

        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumb = new ListNode();
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode result = dumb;
        boolean add = false;
        while (node1 != null && node2 != null) {

            int sum = node1.val + node2.val;
            if (add) sum ++;

            if (sum >= 10) {
                add = true;
                sum = sum % 10;
            } else {
                add = false;
            }

            result.next = new ListNode(sum);
            result = result.next;
            node1 = node1.next;
            node2 = node2.next;

        }

        while (node1 != null) {
            int sum = node1.val;
            if (add) sum ++;

            if (sum >= 10) {
                add = true;
                sum = sum % 10;
            } else {
                add = false;
            }

            result.next = new ListNode(sum);
            result = result.next;
            node1 = node1.next;

        }

        while (node2 != null) {
            int sum = node2.val;
            if (add) sum ++;

            if (sum >= 10) {
                add = true;
                sum = sum % 10;
            } else {
                add = false;
            }

            result.next = new ListNode(sum);
            result = result.next;
            node2 = node2.next;
        }

        if (add) {
            result.next = new ListNode(1);
        }

        return dumb.next;
    }

    private static ListNode reverse(ListNode node) {
        ListNode previous = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }

        return previous;
    }
}
