package arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlapingInterval {

    /**
     * [1, 22],
     * [-20, 30]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] result = mergeOverlappingIntervals(new int[][] {
                {2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}
        });

        for (int[] array : result) {
            System.out.println(array[0] + " " + array[1]);
        }
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });


        ArrayList<int[]> result = new ArrayList<int[]>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int last = result.size() - 1;
            if (result.get(last)[1] < intervals[i][0]) {
                result.add(last + 1, intervals[i]);
            } else  {
                result.set(last, new int[] {
                        Math.min(result.get(last)[0], intervals[i][0]),
                        Math.max(intervals[i][1], result.get(last)[1])
                });
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

}
