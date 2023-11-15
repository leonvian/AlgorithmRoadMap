package linkedlist;

public class ReverseLinkedList206 {

    public static ListNode reverse(ListNode node) {
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
