package arraysandhashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MinOperationsToMakeArrayDistinct {

    public static void main(String[] args) {
        minimumOperations(new int[] {1,2,3, 4,2,3, 3,5,7});
    }

    public static int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        boolean isUnique = true;
        //[1,2,3, 4,2,3, 3,5,7]

        for (int num : nums) {
            int count = 0;
            if (map.containsKey(num)) {
                count = map.get(num);
                isUnique = false;
            }
            count ++;
            map.put(num, count);
        }

        if (isUnique) return 0;

        Set<Integer> keys = new HashSet(map.keySet());
        for (int key : keys) {
            if (map.get(key) <= 1)
                map.remove(key);
        }

        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i])) {
                reduce(nums[i], map);
                if (map.isEmpty()) {
                    return calcOps(i + 1);
                }
            }
        }

        return calcOps(nums.length);
    }

    private static int calcOps(int i) {
        if (i <= 3) return 1;

        int ops = i / 3;
        if (i % 3 != 0) {
            ops ++;
        }

        return ops;
    }

    private static void reduce(int key, HashMap<Integer, Integer> map) {
        int count = map.get(key);
        if (count <= 2) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }

}
