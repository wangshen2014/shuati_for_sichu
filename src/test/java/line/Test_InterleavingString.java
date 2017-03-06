package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/7/16.
 */
public class Test_InterleavingString {
    InterleavingString[] _testObjs = new InterleavingString[]{
            new InterleavingString_Impl_161007_0(),
    };

    private void verify(boolean expected, boolean actual) {
        assertEquals(expected, actual);

    }

    @Test
    public void test1() {
        // input
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        // expected result
        boolean expected = true;

        // call func to get actual result
        for (InterleavingString testObj : _testObjs) {
            boolean actual = testObj.isInterleave(s1, s2, s3);
            verify(expected, actual);
        }
    }

    @Test
    public void test2() {
        // input
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";

        // expected result
        boolean expected = false;

        // call func to get actual result
        for (InterleavingString testObj : _testObjs) {
            boolean actual = testObj.isInterleave(s1, s2, s3);
            verify(expected, actual);
        }
    }
}
