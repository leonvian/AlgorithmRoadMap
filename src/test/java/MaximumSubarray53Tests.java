import greedy.MaximumSubarray53;
import org.junit.Assert;
import org.junit.Test;

public class MaximumSubarray53Tests {

    @Test
    public void testCase1() {
        Assert.assertEquals(6, MaximumSubarray53.maxSubArray(new int[] { -2,1,-3,4,-1,2,1,-5,4 }));
    }
}
