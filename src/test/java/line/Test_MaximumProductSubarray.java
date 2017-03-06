package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/4/16.
 */
public class Test_MaximumProductSubarray {
    MaximumProductSubarray[] _testObjs = new MaximumProductSubarray[]{
            new MaximumProductSubarray_Impl_161004_0(),
    };

    private void verify(int expected, int rst) {
        assertEquals(expected, rst);
    }

    @Test
    public void test1() {
        // input
        int[] nums = new int[]{2, 3, -2, 4};

        // expected result
        int expected = 6;

        // call func to get actual result
        for (MaximumProductSubarray testObj : _testObjs) {
            int rst = testObj.maxProduct(nums);
            verify(expected, rst);
        }
    }

    @Test
    public void test2() {
        // input
        int[] nums = new int[]{-2, 3, -4};

        // expected result
        int expected = 24;

        // call func to get actual result
        for (MaximumProductSubarray testObj : _testObjs) {
            int rst = testObj.maxProduct(nums);
            verify(expected, rst);
        }
    }

    @Test
    public void test3() {
        // input
        int[] nums = new int[]{0, 2};

        // expected result
        int expected = 2;

        // call func to get actual result
        for (MaximumProductSubarray testObj : _testObjs) {
            int rst = testObj.maxProduct(nums);
            verify(expected, rst);
        }
    }

    @Test
    public void test4() {
        // input
        int[] nums = new int[]{3,-1,4};

        // expected result
        int expected = 4;

        // call func to get actual result
        for (MaximumProductSubarray testObj : _testObjs) {
            int rst = testObj.maxProduct(nums);
            verify(expected, rst);
        }
    }

    @Test
    public void test5() {
        // input
        int[] nums = new int[]{2,-5,-2,-4,3};

        // expected result
        int expected = 24;

        // call func to get actual result
        for (MaximumProductSubarray testObj : _testObjs) {
            int rst = testObj.maxProduct(nums);
            verify(expected, rst);
        }
    }

}
