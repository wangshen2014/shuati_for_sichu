package sort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/13/16.
 */
public class Test_ShortestWordDistance {
    ShortestWordDistance[] _testObjs = new ShortestWordDistance[]{
            new ShortestWordDistance_Impl_161013_0(),
    };

    private void verify(int expected, int actual) {
        assertEquals(expected, actual);

    }

    @Test
    public void test1() {
        // input
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";

        // expected result
        int expected = 3;

        // call func to get actual result
        for (ShortestWordDistance testObj : _testObjs) {
            int actual = testObj.shortestDistance(words, word1, word2);
            verify(expected, actual);
        }
    }

    @Test
    public void test2() {
        // input
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";

        // expected result
        int expected = 1;

        // call func to get actual result
        for (ShortestWordDistance testObj : _testObjs) {
            int actual = testObj.shortestDistance(words, word1, word2);
            verify(expected, actual);
        }
    }
}
