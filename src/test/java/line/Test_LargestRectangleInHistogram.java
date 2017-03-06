package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/6/16.
 */
public class Test_LargestRectangleInHistogram {
    LargestRectangleInHistogram[] _testObjs = new LargestRectangleInHistogram[]{
            new LargestRectangleInHistogram_Impl_161006_0(),
    };

    private void verify(int expected, int actual) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        // input
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};

        // expected result
        int expected = 10;

        // call func to get actual result
        for (LargestRectangleInHistogram testObj : _testObjs) {
            int actual = testObj.largestRectangleArea(heights);
            verify(expected, actual);
        }
    }
}
