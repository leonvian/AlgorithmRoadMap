package linkedlist;

public class RemoveNthNode {

    public static void main(String[] args) {
        //[1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);

        removeNthFromEnd(head, 2);
    }
  //  1 -> 2 -> null
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n > 0) {
            if (fast == null) return null;
            fast = fast.next;
            n --;
        }

        if (fast == null) return head.next;

        ListNode slow = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

}
