package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/9/16.
 */
public class Test_PatchingArray {
    PatchingArray[] _testObjs = new PatchingArray[]{
            new PatchingArray_Impl_161009_0(),
    };

    private void verify(int expected, int actual) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        // input
        int[] nums = new int[]{1, 3};
        int n = 6;

        // expected result
        int expected = 1;

        // call func to get actual result
        for (PatchingArray testObj : _testObjs) {
            int actual = testObj.minPatches(nums, n);
            verify(expected, actual);
        }
    }

    @Test
    public void test2() {
        // input
        int[] nums = new int[]{1, 5, 10};
        int n = 20;

        // expected result
        int expected = 2;

        // call func to get actual result
        for (PatchingArray testObj : _testObjs) {
            int actual = testObj.minPatches(nums, n);
            verify(expected, actual);
        }
    }

    @Test
    public void test3() {
        // input
        int[] nums = new int[]{1, 2, 2};
        int n = 5;

        // expected result
        int expected = 0;

        // call func to get actual result
        for (PatchingArray testObj : _testObjs) {
            int actual = testObj.minPatches(nums, n);
            verify(expected, actual);
        }
    }
}
