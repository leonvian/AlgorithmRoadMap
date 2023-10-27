package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStone {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{1,3}));
    }

    private static int lastStoneWeight(int[] array) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int current : array) {
            heap.add(current);
        }

        while (heap.size() > 1) {
            int first = heap.poll();
            int second = heap.poll();

            if (first != second) {
                int result = Math.max(first, second) - Math.min(first, second);
                heap.add(result);
            }
        }

        if (heap.size() == 1)
            return heap.poll();
        else
            return 0;
    }

}
