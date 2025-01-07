package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGifts {

    public static void main(String[] args) {
        pickGifts(new int[] {25,64,9,4,100}, 4);
    }

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int gift : gifts) {
            pq.add(gift);
        }

        for (int i = 0; i < k; i ++) {
            int bigGift = pq.poll();
            double val = Math.sqrt(bigGift);
            int result = (int)Math.floor(val);
            pq.add(result);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }

}
