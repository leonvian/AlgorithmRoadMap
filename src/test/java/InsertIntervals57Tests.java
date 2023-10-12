import intervals.InsertIntervals57;
import org.junit.Assert;
import org.junit.Test;

public class InsertIntervals57Tests {

    @Test
    public void testCaseAddOnTheStart() {
        int[][] result = InsertIntervals57.insert( new int[][] { {3,5}, {6,9} }, new int[] { 1,2 });
        Assert.assertEquals(result[0][0], 1);
        Assert.assertEquals(result[0][1], 2);


        Assert.assertEquals(result[1][0], 3);
        Assert.assertEquals(result[1][1], 5);

        Assert.assertEquals(result[2][0], 6);
        Assert.assertEquals(result[2][1], 9);
    }

    @Test
    public void testCaseAddOnTheEnd() {
        int[][] result = InsertIntervals57.insert( new int[][] { {3,5}, {6,9} }, new int[] { 10, 12 });

        Assert.assertEquals(result[0][0], 3);
        Assert.assertEquals(result[0][1], 5);

        Assert.assertEquals(result[1][0], 6);
        Assert.assertEquals(result[1][1], 9);

        Assert.assertEquals(result[2][0], 10);
        Assert.assertEquals(result[2][1], 12);
    }

    @Test
    public void testCase1() {
        int[][] result = InsertIntervals57.insert( new int[][] { {1,3}, {6,9} }, new int[] { 2,5 });
        Assert.assertEquals(result[0][0], 1);
        Assert.assertEquals(result[0][1], 5);


        Assert.assertEquals(result[1][0], 6);
        Assert.assertEquals(result[1][1], 9);
    }

    @Test
    public void testCase2() {
        int[][] result = InsertIntervals57.insert( new int[][] {
                {1,2}, {3,5},{6,7},{8,10},{12,16}
        }, new int[] { 4,8 });

        Assert.assertEquals(1, result[0][0]);
        Assert.assertEquals( 2, result[0][1]);

        Assert.assertEquals( 3, result[1][0]);
        Assert.assertEquals( 10, result[1][1]);

        Assert.assertEquals( 12, result[2][0]);
        Assert.assertEquals( 16, result[2][1]);
    }
}
