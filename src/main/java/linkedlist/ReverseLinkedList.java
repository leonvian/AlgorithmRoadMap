package linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        print(node1);

        Node head = reverse(node1);

        print(head);

    }


    private static void print(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.value);
            node = node.next;
        }

        System.out.println(sb);
    }

    private static Node reverse(Node node) {
        Node previous = null;

        while (node != null) {
            Node next = node.next;
            node.next = previous;
            previous = node;
            node = next;
        }

        return previous;
    }


    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
