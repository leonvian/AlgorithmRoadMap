package linkedlist;

public class ReverseLinkedList206 {

    public static Node reverse(Node node) {
        Node previous = null;

        while (node != null) {
            Node next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }

        return previous;
    }


    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
