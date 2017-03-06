package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/17/16.
 */
public class Test_NQueens {
    NQueens[] _testObjs = new NQueens[]{
            new NQueens_Impl_161017_0(),
    };

    private void verify(List<List<String>> expected, List<List<String>> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            for (int j = 0; j < expected.size(); j++) {
                assertEquals(expected.get(i).get(j), actual.get(i).get(j));
            }
        }
    }

    @Test
    public void test1() {
        // input
        int n = 4;

        // expected result
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(".Q..", "...Q", "Q...", "Q...")));
        expected.add(new ArrayList<>(Arrays.asList("..Q.", "Q...", "...Q", ".Q..")));


        // call func to get actual result
        for (NQueens testObj : _testObjs) {
            List<List<String>> actual = testObj.solveNQueens(n);
            verify(expected, actual);
        }
    }

    @Test
    public void test2() {
        // input
        int n = 5;

        // expected result
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList("Q....", "..Q..", "....Q", ".Q...", "...Q.")));
        expected.add(new ArrayList<>(Arrays.asList("Q....", "...Q.", ".Q...", "....Q", "..Q..")));
        expected.add(new ArrayList<>(Arrays.asList(".Q...", "...Q.", "Q....", "..Q..", "....Q")));
        expected.add(new ArrayList<>(Arrays.asList(".Q...", "....Q", "..Q..", "Q....", "...Q.")));
        expected.add(new ArrayList<>(Arrays.asList("..Q..", "Q....", "...Q.", ".Q...", "....Q")));
        expected.add(new ArrayList<>(Arrays.asList("..Q..", "....Q", ".Q...", "...Q.", "Q....")));
        expected.add(new ArrayList<>(Arrays.asList("...Q.", "Q....", "..Q..", "....Q", ".Q...")));
        expected.add(new ArrayList<>(Arrays.asList("...Q.", ".Q...", "....Q", "..Q..", "Q....")));
        expected.add(new ArrayList<>(Arrays.asList("....Q", ".Q...", "...Q.", "Q....", "..Q..")));
        expected.add(new ArrayList<>(Arrays.asList("....Q", "..Q..", "Q....", "...Q.", ".Q...")));


        // call func to get actual result
        for (NQueens testObj : _testObjs) {
            List<List<String>> actual = testObj.solveNQueens(n);
            verify(expected, actual);
        }
    }
}
