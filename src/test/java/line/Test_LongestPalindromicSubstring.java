package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/6/16.
 */
public class Test_LongestPalindromicSubstring {
    LongestPalindromicSubstring[] _testObjs = new LongestPalindromicSubstring[]{
            new LongestPalindromicSubstring_Impl_161006_0(),
    };

    private void verify(String expected, String actual) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        // input
        String s = "ppoabccbaadfhellollehabdf";
        // expected result
        String  expected ="hellolleh";

        // call func to get actual result
        for (LongestPalindromicSubstring testObj : _testObjs) {
            String actual = testObj.longestPalindrome(s);
            verify(expected, actual);
        }
    }


    @Test
    public void test2() {
        // input
        String s = "bb";
        // expected result
        String  expected ="bb";

        // call func to get actual result
        for (LongestPalindromicSubstring testObj : _testObjs) {
            String actual = testObj.longestPalindrome(s);
            verify(expected, actual);
        }
    }


    @Test
    public void test3() {
        // input
        String s = "ccd";
        // expected result
        String  expected ="cc";

        // call func to get actual result
        for (LongestPalindromicSubstring testObj : _testObjs) {
            String actual = testObj.longestPalindrome(s);
            verify(expected, actual);
        }
    }


    @Test
    public void test4() {
        // input
        String s = "ccc";
        // expected result
        String  expected ="ccc";

        // call func to get actual result
        for (LongestPalindromicSubstring testObj : _testObjs) {
            String actual = testObj.longestPalindrome(s);
            verify(expected, actual);
        }
    }
}
