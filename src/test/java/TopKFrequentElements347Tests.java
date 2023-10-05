import arraysandhashing.TopKFrequentElements347;
import org.junit.Assert;
import org.junit.Test;

public class TopKFrequentElements347Tests {

    @Test
    public void testcase_1() {
        TopKFrequentElements347.Solution sol = new TopKFrequentElements347.Solution();
        int[] result = sol.topKFrequent(new int[] {1,1,1,2,2,3}, 2);

        Assert.assertEquals(2, result.length);
        Assert.assertEquals(1, result[0]);
        Assert.assertEquals(2, result[1]);
    }

    @Test
    public void testcase_2() {
        TopKFrequentElements347.Solution sol = new TopKFrequentElements347.Solution();
        int[] result = sol.topKFrequent(new int[] {1,2}, 2);

        Assert.assertEquals(2, result.length);
        Assert.assertEquals(1, result[0]);
        Assert.assertEquals(2, result[1]);
    }
    //[1,2]

}
