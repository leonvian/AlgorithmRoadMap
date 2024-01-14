package linkedlist;

public class ReorderList {

    //[1 -> 2 -> 3 -> 4]
    //[1 -> 4 -> 2 -> 3]
    public static void main(String[] args) {
        //head = [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next =  new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        ListNode previous = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = previous;
            previous = second;
            second = tmp;
        }

        second = previous;

        ListNode first = head;

        // 1 -> 2 -> 4 -> 3

        // 1 -> 4 -> 3
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;
            second = tmp2;
            first = tmp1;
        }

        System.out.println("");
   //     reorderList(head);
    }

    public static void reorderList(ListNode head) {
        ListNode headHolder = new ListNode();
        headHolder.next = head;

        ListNode reversed = reverse(head, null);

        ListNode original = headHolder.next;

        ListNode dummy = new ListNode();
        ListNode currentResult = dummy;

        boolean useOriginal = true;
        while (reversed != null && original != null) {
            if (useOriginal) {
                currentResult.next = original;
                original = original.next;
                useOriginal = false;
            } else {
                currentResult.next = reversed;
                reversed = reversed.next;
                useOriginal = true;
            }

            currentResult = currentResult.next;
        }


        head = dummy.next;
    }


    // 1 - 2 - 3 - 4 - 5 - 6
    private static ListNode reverse(ListNode node, ListNode previous) {
        if (node == null) return previous;

        ListNode next = node.next;
        node.next = previous;
        previous = node;

        return reverse(next, previous);
    }
}
