package intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/meeting-rooms/
 */
public class MeetingRooms252 {


    public static boolean canAttendMeetings(int[][] intervals) {
        List<Interval> listInterval = new ArrayList<>();
        for (int[] interval : intervals) {
            listInterval.add(new Interval(interval[0], interval[1]));
        }

        if (listInterval.isEmpty()) return true;

        Collections.sort(listInterval);

        Interval first = listInterval.get(0);
        for (int i = 1; i < listInterval.size(); i ++) {
            Interval second = listInterval.get(i);

            if (first.end > second.start) {
                return false;
            }

            first = second;
        }

        return true;
    }


    private static class Interval implements Comparable<Interval>  {

        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(this.start, o.start);
        }
    }

}
