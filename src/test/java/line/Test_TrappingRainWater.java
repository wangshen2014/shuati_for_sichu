package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/6/16.
 */
public class Test_TrappingRainWater {
    TrappingRainWater[] _testObjs = new TrappingRainWater[]{
            new TrappingRainWater_Impl_161006_0(),
    };

    private void verify(int expected, int actual) {
        assertEquals(expected, actual);

    }

    @Test
    public void test1() {
        // input
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        // expected result
        int expected = 6;

        // call func to get actual result
        for (TrappingRainWater testObj : _testObjs) {
            int actual = testObj.trap(height);
            verify(expected, actual);
        }
    }
}
