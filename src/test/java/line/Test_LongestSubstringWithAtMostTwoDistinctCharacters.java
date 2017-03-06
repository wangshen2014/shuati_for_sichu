package line;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/3/16.
 */
public class Test_LongestSubstringWithAtMostTwoDistinctCharacters {
    LongestSubstringWithAtMostTwoDistinctCharacters[] _testObjs = new LongestSubstringWithAtMostTwoDistinctCharacters[]{
//            new LongestSubstringWithAtMostTwoDistinctCharacters_Impl_161003_0(),
//            new LongestSubstringWithAtMostTwoDistinctCharacters_Impl_161003_1(),
            new LongestSubstringWithAtMostTwoDistinctCharacters_Impl_161003_2()
    };

    private void verify(int expected, int rst) {
        assertEquals(expected, rst);
    }

    @Test
    public void test1() {
        // input
        String s = "eceba";

        // expected result
        int expected = 3;

        // call func to get actual result
        for (LongestSubstringWithAtMostTwoDistinctCharacters testObj : _testObjs) {
            int rst = testObj.lengthOfLongestSubstringTwoDistinct(s);
            verify(expected, rst);
        }
    }


    @Test
    public void test2() {
        // input
        String s = "aabbaaabbbaaa";

        // expected result
        int expected = 13;

        // call func to get actual result
        for (LongestSubstringWithAtMostTwoDistinctCharacters testObj : _testObjs) {
            int rst = testObj.lengthOfLongestSubstringTwoDistinct(s);
            verify(expected, rst);
        }
    }


    @Test
    public void test3() {
        // input
        String s = "a";

        // expected result
        int expected = 1;

        // call func to get actual result
        for (LongestSubstringWithAtMostTwoDistinctCharacters testObj : _testObjs) {
            int rst = testObj.lengthOfLongestSubstringTwoDistinct(s);
            verify(expected, rst);
        }
    }

    @Test
    public void test4() {
        // input
        String s = "aac";

        // expected result
        int expected = 3;

        // call func to get actual result
        for (LongestSubstringWithAtMostTwoDistinctCharacters testObj : _testObjs) {
            int rst = testObj.lengthOfLongestSubstringTwoDistinct(s);
            verify(expected, rst);
        }
    }


    @Test
    public void test5() {
        // input
        String s = "abcabcabc";

        // expected result
        int expected = 2;

        // call func to get actual result
        for (LongestSubstringWithAtMostTwoDistinctCharacters testObj : _testObjs) {
            int rst = testObj.lengthOfLongestSubstringTwoDistinct(s);
            verify(expected, rst);
        }
    }
}
