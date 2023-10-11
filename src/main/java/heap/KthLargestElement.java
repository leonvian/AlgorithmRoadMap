package heap;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]  { 4, 5, 8, 2 } );
        int res1 = kthLargest.add(3);
        int res2 = kthLargest.add(5);
        int res3 = kthLargest.add(10);
        int res4 = kthLargest.add(9);
        int res5 = kthLargest.add(4);
    }

    public static class KthLargest {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int k = 0;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int value : nums) {
                minHeap.add(value);
            }
            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            return minHeap.peek();
        }
    }
}
