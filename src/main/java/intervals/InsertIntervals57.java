package intervals;

import java.util.*;

public class InsertIntervals57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; i ++) {
            if (intervals[i][0] > newInterval[1]) {
                result.add(newInterval);
                addAll(intervals, result, i);
                return toArray(result);
            } else if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else {
                newInterval = new int[] {
                        Math.min(newInterval[0], intervals[i][0]),
                        Math.max(newInterval[1], intervals[i][1])
                };
            }
        }

        result.add(newInterval);

        return toArray(result);
    }

    private static void addAll(int[][] intervals, List<int[]> result, int pos) {
        for (; pos < intervals.length; pos ++) {
            result.add(intervals[pos]);
        }
    }

    private static int[][] toArray(List<int[]> result) {
        int[][] resultFinal = new int[result.size()][2];
        int i = 0;
        for (int[] data : result) {
            resultFinal[i] = data;
            i ++;
        }

        return resultFinal;
    }

}
