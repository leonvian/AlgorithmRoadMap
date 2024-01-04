package arraysandhashing;

import java.util.HashMap;

public class MinOperationsToMakeArrayEmpty {

    public static void main(String[] args) {
        System.out.println(minOperations(new int[] {2,3,3,2,2,4,2,3,4}));
    }

    private static int minOperations(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap();

        for (int value : nums) {
            int count = 0;
            if (counter.containsKey(value)) {
                count = counter.get(value);
            }
            count ++;
            counter.put(value, count);
        }

        int ops = 0;
        for (int value : counter.keySet()) {
            int count = counter.get(value);

            int min = min(count, new HashMap<Integer, Integer>());
            if (min == Integer.MAX_VALUE) return -1;
            ops += min;

        }

        return ops;
    }

    private static int min(int value, HashMap<Integer, Integer> cache) {
        if (value <= 1) return Integer.MAX_VALUE;
        if (value == 2) return 1;
        if (value == 3) return 1;
        if (cache.containsKey(value)) return cache.get(value);

        cache.put(value, 1 + Math.min(
                min(value -2, cache),
                min(value -3, cache)
        ));

        return cache.get(value);
    }
}
