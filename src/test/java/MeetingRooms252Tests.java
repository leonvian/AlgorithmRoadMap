import intervals.MeetingRooms252;
import org.junit.Assert;
import org.junit.Test;

public class MeetingRooms252Tests {

    @Test
    public void testCase1() {
        int[][] meetings = new int[][] { {0,30},{5,10},{15,20} };
        Assert.assertFalse(MeetingRooms252.canAttendMeetings(meetings));
    }

    @Test
    public void testCase2() {
        int[][] meetings = new int[][] { {2,4},{7, 8} };
        Assert.assertTrue(MeetingRooms252.canAttendMeetings(meetings));
    }

    @Test
    public void testCase3() {
        int[][] meetings = new int[][] {  };
        Assert.assertTrue(MeetingRooms252.canAttendMeetings(meetings));
    }
}
