package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/10/16.
 */
public class Test_RemoveDuplicateLetters {
    RemoveDuplicateLetters[] _testObjs = new RemoveDuplicateLetters[]{
            new RemoveDuplicateLetters_Impl_161010_0(),
    };

    private void verify(String expected, String actual) {
        assertEquals(expected, actual);

    }

    @Test
    public void test1() {
        // input
        String s = "bcabc";

        // expected result
        String expected = "abc";

        // call func to get actual result
        for (RemoveDuplicateLetters testObj : _testObjs) {
            String actual = testObj.removeDuplicateLetters(s);
            verify(expected, actual);
        }
    }

    @Test
    public void test2() {
        // input
        String s = "cbacdcbc";

        // expected result
        String expected = "acdb";

        // call func to get actual result
        for (RemoveDuplicateLetters testObj : _testObjs) {
            String actual = testObj.removeDuplicateLetters(s);
            verify(expected, actual);
        }
    }
}
