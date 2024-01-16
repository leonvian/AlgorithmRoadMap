package linkedlist;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
