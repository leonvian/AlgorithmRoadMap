import binarysearch.BinarySearch704;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearch704Tests {

    @Test
    public void testCase1() {
        Assert.assertEquals(2, BinarySearch704.search(new int[] {1,2,3,4,5,9}, 3));
    }

    @Test
    public void testCase2() {
        Assert.assertEquals(0, BinarySearch704.search(new int[] {1,2,3,4,5,9}, 1));
    }

    @Test
    public void testCase3() {
        Assert.assertEquals(-1, BinarySearch704.search(new int[] {1,2,3,4,5,9}, 6));
    }
}
