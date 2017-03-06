package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 9/30/16.
 */
public class Test_ReverseWordsInAString {
    ReverseWordsInAString[] _testObjs = new ReverseWordsInAString[]{
//            new ReverseWordsInAStringImpl_160930_0(),
            new ReverseWordsInAString_Impl_160930_1(),
            new ReverseWordsInAString_Impl_161001_0()
    };

    private void verify(String rst, String expected) {
        assertEquals(rst, expected);
    }

    @Test
    public void test1() {
        // input
        String s = "the sky is blue";

        // expected result
        String expected = "blue is sky the";

        // call func to get actual result
        for (ReverseWordsInAString testObj : _testObjs) {
            String rst = testObj.reverseWords(s);
            verify(rst, expected);
        }
    }

    @Test
    public void test2() {
        // input
        String s = "   the sky is blue   ";

        // expected result
        String expected = "blue is sky the";

        // call func to get actual result
        for (ReverseWordsInAString testObj : _testObjs) {
            String rst = testObj.reverseWords(s);
            verify(rst, expected);
        }
    }
}
