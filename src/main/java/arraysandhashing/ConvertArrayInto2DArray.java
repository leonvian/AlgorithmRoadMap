package arraysandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
public class ConvertArrayInto2DArray {
    public static void main(String[] args) {
        findMatrix(new int[] {1,3,4,1,2,3,1});
    }

    private static List<List<Integer>> findatrix_sol2(int[] nums) {
        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int value : nums) {
            int row = 0;
            if (data.containsKey(value)) {
                row = data.get(value);
            }

            if (row < result.size() ) {
                result.get(row).add(value);
            } else {
                ArrayList<Integer> current = new ArrayList();
                current.add(value);
                result.add(row, current);
            }

            data.put(value, row +1);
        }


        return result;
    }

    private static List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
        for (int value : nums) {
            int count = 0;
            if (data.containsKey(value)) {
                count = data.get(value);
            }
            count ++;
            data.put(value, count);
        }

        PriorityQueue<ArrayValue> pq = new PriorityQueue<ArrayValue>();
        for (int value : data.keySet()) {
            int size = data.get(value);
            pq.add(new ArrayValue(value, size));
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        while (!pq.isEmpty()) {
            ArrayValue value = pq.poll();
            int size = Math.abs(value.size);
            boolean isEmpty = result.isEmpty();
            for (int row = 0; row < size; row ++) {
                if (isEmpty) {
                    ArrayList<Integer> currentList = new ArrayList<Integer>();
                    currentList.add(value.value);
                    result.add(row, currentList);
                } else {
                    result.get(row).add(value.value);
                }
            }
        }

        return result;
    }

    public static class ArrayValue implements Comparable  {
        public int value;
        public int size;

        public ArrayValue(int value, int size) {
            this.value = value;
            this.size = size;
        }

        public int compareTo(Object obj) {
            ArrayValue other = (ArrayValue)obj;

            return Integer.compare(other.size, size);
        }
    }

}
