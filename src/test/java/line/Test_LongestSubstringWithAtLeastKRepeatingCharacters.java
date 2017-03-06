package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/8/16.
 */
public class Test_LongestSubstringWithAtLeastKRepeatingCharacters {
    LongestSubstringWithAtLeastKRepeatingCharacters[] _testObjs = new LongestSubstringWithAtLeastKRepeatingCharacters[]{
            new LongestSubstringWithAtLeastKRepeatingCharacters_Impl_161008_0(),
    };

    private void verify(int expected, int actual) {
        assertEquals(expected, actual);

    }

    @Test
    public void test1() {
        // input
        String s = "ababbc";
        int k = 2;

        // expected result
        int expected = 5;

        // call func to get actual result
        for (LongestSubstringWithAtLeastKRepeatingCharacters testObj : _testObjs) {
            int actual = testObj.longestSubstring(s, k);
            verify(expected, actual);
        }
    }

    @Test
    public void test2() {
        // input
        String s = "aaabb";
        int k = 3;

        // expected result
        int expected = 3;

        // call func to get actual result
        for (LongestSubstringWithAtLeastKRepeatingCharacters testObj : _testObjs) {
            int actual = testObj.longestSubstring(s, k);
            verify(expected, actual);
        }
    }
}
