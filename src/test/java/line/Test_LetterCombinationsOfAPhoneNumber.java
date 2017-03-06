package line;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/2/16.
 */
public class Test_LetterCombinationsOfAPhoneNumber {
    LetterCombinationsOfAPhoneNumber[] _testObjs = new LetterCombinationsOfAPhoneNumber[]{
            new LetterCombinationsOfAPhoneNumber_Impl_161002_0(),
    };

    private void verify(List<String> expected, List<String> rst) {

        Collections.sort(expected);
        Collections.sort(rst);

        assertEquals(expected.size(), rst.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), rst.get(i));
        }
    }

    @Test
    public void test1() {
        // input
        String digits = "23";

        // expected result
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

        // call func to get actual result
        for (LetterCombinationsOfAPhoneNumber testObj : _testObjs) {
            List<String> rst = testObj.letterCombinations(digits);
            verify(expected, rst);
        }
    }

    @Test
    public void test2() {
        // input
        String digits = "";

        // expected result
        List<String> expected = Arrays.asList();

        // call func to get actual result
        for (LetterCombinationsOfAPhoneNumber testObj : _testObjs) {
            List<String> rst = testObj.letterCombinations(digits);
            verify(expected, rst);
        }
    }

    @Test
    public void test3() {
        // input
        String digits = "";

        // expected result
        List<String> expected = Arrays.asList();

        // call func to get actual result
        for (LetterCombinationsOfAPhoneNumber testObj : _testObjs) {
            List<String> rst = testObj.letterCombinations(digits);
            verify(expected, rst);
        }
    }
}
