package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/4/16.
 *
 *
 */
public class Test_MaximumSubarray {
    MaximumSubarray[] _testObjs = new MaximumSubarray[]{
            new MaximumSubarray_Impl_161004_0(),
            new MaximumSubarray_Impl_161004_1()
    };

    private void verify(int expected, int rst) {
        assertEquals(expected, rst);
    }

    @Test
    public void test1() {
        // input
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};

        // expected result
        int expected = 6;

        // call func to get actual result
        for (MaximumSubarray testObj : _testObjs) {
            int rst = testObj.maxSubArray(nums);
            verify(expected,rst);
        }
    }
}

