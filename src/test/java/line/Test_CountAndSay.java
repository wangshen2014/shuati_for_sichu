package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by patrickyu on 9/30/16.
 */
public class Test_CountAndSay {

    CountAndSay[] _testObjs = new CountAndSay[]{
            new CountAndSay_Impl_160930_0(), // 边界问题
            new CountAndSay_Impl_160930_1()
    };

    private void verify(String expected, String rst) {
        assertEquals(expected, rst);
    }

    @Test
    public void test1() {
        // input
        int n = 6;

        // expected result
        String expected = "312211";

        // call func to get actual result
        for (CountAndSay testObj : _testObjs) {
            String rst = testObj.countAndSay(n);
            verify(expected, rst);
        }

    }

    @Test
    public void test2() {
        // input
        int n = 7;

        // expected result
        String expected = "13112221";

        // call func to get actual result
        for (CountAndSay testObj : _testObjs) {
            String rst = testObj.countAndSay(n);
            verify(expected, rst);
        }
    }

    @Test
    public void testException() {
        //input
        int n = 0;


        for (CountAndSay testObject : _testObjs) {
            try {
                testObject.countAndSay(n);
                fail(); // 表示上面这行并没有执行完
            } catch (IllegalArgumentException e) {
                assertEquals(e.getMessage(), CountAndSay_Abstract.ILLEGAL_ARGUMENT_MESSAGE);
            }
        }
    }
}
