package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/1/16.
 */
public class Test_MinimumWindowSubstring {
    MinimumWindowSubstring[] _testObjs = new MinimumWindowSubstring[]{
//            new MinimumWindowSubstring_Impl_161001_0(),
//            new MinimumWindowSubstring_Impl_161001_1(),
//            new MinimumWindowSubstring_Impl_161001_2(),
        new MinimumWindowSubstring_Impl_161003_0()
    };


    private void verify(String expected, String rst) {
        assertEquals(expected, rst);
    }

    @Test
    public void test1() {
        // input
        String S = "ADOBECODEBANC";
        String T = "ABC";

        // expected result
        String expected = "BANC";

        // call func to get actual result
        for (MinimumWindowSubstring testObj : _testObjs) {
            String rst = testObj.minWindow(S, T);
            verify(expected, rst);
        }
    }


    @Test
    public void test2() {
        // input
        String S = "AA";
        String T = "AA";

        // expected result
        String expected = "AA";

        // call func to get actual result
        for (MinimumWindowSubstring testObj : _testObjs) {
            String rst = testObj.minWindow(S, T);
            verify(expected, rst);
        }
    }


    @Test
    public void test3() {
        // input
        String S = "BBA";
        String T =  "AB";

        // expected result
        String expected = "BA";

        // call func to get actual result
        for (MinimumWindowSubstring testObj : _testObjs) {
            String rst = testObj.minWindow(S, T);
            verify(expected, rst);
        }
    }


    @Test
    public void test4() {
        // input
        String S = "CAAE";
        String T =  "CAE";

        // expected result
        String expected = "CAAE";

        // call func to get actual result
        for (MinimumWindowSubstring testObj : _testObjs) {
            String rst = testObj.minWindow(S, T);
            verify(expected, rst);
        }
    }
}
