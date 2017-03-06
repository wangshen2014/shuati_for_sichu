package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by patrickyu on 9/29/16.
 */
public class Test_RemoveElement {

    RemoveElement[] _testObjs = new RemoveElement[]{
            new RemoveElement_Impl_160930_0(),
    };

    private void verify(int[] nums, int[] expected, int len) {
        assertEquals(len, expected.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(nums[i], expected[i]);
        }
    }

    @Test
    public void test1() {
        // input
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;

        // expected result
        int[] expected = new int[]{2, 2};

        // call func to get actual result
        for (RemoveElement testObj : _testObjs) {
            int len = testObj.removeElement(nums, val);
            verify(nums, expected, len);
        }
    }

    @Test
    public void testExceptionTemplate() {
        //input
        int[] array = new int[]{};
        int target = 99;

        for (RemoveElement testObject : _testObjs) {
            try {
                testObject.removeElement(array, target);
                fail(); // 表示上面这行并没有执行完
            } catch (IllegalArgumentException e) {
                assertEquals(e.getMessage(), "invalid input argument");
            }
        }
    }
}

