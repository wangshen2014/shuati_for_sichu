package line;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 9/30/16.
 */
public class Test_TextJustification {

    TextJustification[] _testObjs = new TextJustification[]{
//            new TextJustification_Impl_160930_0(),
            new TextJustification_Impl_161001_0(),
    };

    private void verify(List<String> rst, List<String> expected) {
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(rst.get(i), expected.get(i));
        }
    }

    /**
     * 这个是不考虑空格的那种 test
     */
    @Test
    public void test1() {
        // input
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        // expected result
        List<String> expected = Arrays.asList("This is an", "example of text", "justification.");

        // call func to get actual result
        for (TextJustification testObj : _testObjs) {
            List<String> rst = testObj.fullJustify(words, maxWidth);
            System.out.println(rst);
            verify(rst, expected);
        }
    }

    /**
     * 这个是 真正考虑 空格的那种 test
     */
    @Test
    public void test2() {
        // input
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;

        // expected result
        List<String> expected = Arrays.asList("This    is    an", "example  of text", "justification.  ");

        // call func to get actual result
        for (TextJustification testObj : _testObjs) {
            List<String> rst = testObj.fullJustify(words, maxWidth);
            verify(rst, expected);
        }
    }

    @Test
    public void test3() {
        // input
        String[] words = new String[]{"What", "must", "be", "shall", "be."};
        int maxWidth = 12;

        // expected result
        List<String> expected = Arrays.asList("What must be", "shall be.   ");

        // call func to get actual result
        for (TextJustification testObj : _testObjs) {
            List<String> rst = testObj.fullJustify(words, maxWidth);
            verify(rst, expected);
        }
    }

    @Test
    public void test4() {
        // input
        String[] words = new String[]{"Listen","to","many,","speak","to","a","few."};
        int maxWidth = 12;

        // expected result
        List<String> expected = Arrays.asList("Listen","to    ","many, ","speak ","to   a","few.  ");

        // call func to get actual result
        for (TextJustification testObj : _testObjs) {
            List<String> rst = testObj.fullJustify(words, maxWidth);
            verify(rst, expected);
        }
    }
}

