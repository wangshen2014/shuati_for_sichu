package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/16/16.
 */
public class Test_GenerateParentheses {
    GenerateParentheses[] _testObjs = new GenerateParentheses[]{
            new GenerateParentheses_Impl_161016_0(),
    };

    private void verify(List<String> expected, List<String> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void test1() {
        // input
        int n = 3;

        // expected result
        List<String> expected = new ArrayList<>(Arrays.asList(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"
        ));


        // call func to get actual result
        for (GenerateParentheses testObj : _testObjs) {
            List<String> actual = testObj.generateParenthesis(n);
            verify(expected, actual);
        }
    }
}
