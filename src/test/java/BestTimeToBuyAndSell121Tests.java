import binarysearch.BinarySearch704;
import org.junit.Assert;
import org.junit.Test;
import slidingwindow.BestTimeToBuyAndSell121;

public class BestTimeToBuyAndSell121Tests {

    @Test
    public void testCase1_positiveProfit() {
        Assert.assertEquals(5, BestTimeToBuyAndSell121.maxProfit(new int[] { 7,1,5,3,6,4 }));
    }

    @Test
    public void testCase2_negativeProfit() {
        Assert.assertEquals(0, BestTimeToBuyAndSell121.maxProfit(new int[] { 7,6,4,3,1 }));
    }

}
