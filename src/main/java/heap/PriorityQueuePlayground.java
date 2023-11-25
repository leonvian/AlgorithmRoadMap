package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuePlayground {


    /**
     *
     Compares its two arguments for order.
     Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

     * @param args
     */
    public static void main(String[] args) {
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.value, o2.value);
            }
        };
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(comparator);

        priorityQueue.add(new Node("L", 10));
        priorityQueue.add(new Node("M", 2));
        priorityQueue.add(new Node("N", 0));
        priorityQueue.add(new Node("L", 5));

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll().name);
        }
    }


    public static class Node {
        String name;
        int value;

        public Node(String name, int value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
