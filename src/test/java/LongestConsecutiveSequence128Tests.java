import arraysandhashing.LongestConsecutiveSequence128;
import org.junit.Assert;
import org.junit.Test;

public class LongestConsecutiveSequence128Tests {

    @Test
    public void test4ConsecutiveValues() {
        int[] nums = new int[] { 100,4,200,1,3,2 };
        LongestConsecutiveSequence128.Solution solution = new LongestConsecutiveSequence128.Solution();
        Assert.assertEquals(4, solution.longestConsecutive(nums));
    }

    @Test
    public void test9ConsecutiveValues() {
        int[] nums = new int[] { 0,3,7,2,5,8,4,6,0,1 };
        LongestConsecutiveSequence128.Solution solution = new LongestConsecutiveSequence128.Solution();
        Assert.assertEquals(9, solution.longestConsecutive(nums));
    }

}
