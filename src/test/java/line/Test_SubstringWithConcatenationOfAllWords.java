package line;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by patrickyu on 10/4/16.
 *
 */
public class Test_SubstringWithConcatenationOfAllWords {
    SubstringWithConcatenationOfAllWords[] _testObjs = new SubstringWithConcatenationOfAllWords[]{
//            new SubstringWithConcatenationOfAllWords_Impl_161004_0(),
//            new SubstringWithConcatenationOfAllWords_Impl_161004_1(),
//            new SubstringWithConcatenationOfAllWords_Impl_161004_2(),
            new SubstringWithConcatenationOfAllWords_Impl_161007_0()

    };

    private void verify(List<Integer> expected, List<Integer> rst) {

        assertEquals(expected.size(), rst.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), rst.get(i));
        }
    }


    @Test
    public void test1() {
        // input
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};

        // expected result
        List<Integer> expected = new ArrayList<>(Arrays.asList(0, 9));

        // call func to get actual result
        for (SubstringWithConcatenationOfAllWords testObj : _testObjs) {
            List<Integer> rst = testObj.findSubstring(s, words);
            verify(expected, rst);
        }
    }


    @Test
    public void test2() {


    }


}
