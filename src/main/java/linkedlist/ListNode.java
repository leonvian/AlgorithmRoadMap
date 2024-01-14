package linkedlist;

public class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
