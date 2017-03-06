package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/4/16.
 */
public class Test_PermutationsII {
    PermutationsII[] _testObjs = new PermutationsII[]{
            new PermutationsII_Impl_161004_0(),
    };

    private void verify(List<List<Integer>> expected, List<List<Integer>> rst) {
        assertEquals(expected.size(), rst.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), rst.get(i));
        }
    }

    @Test
    public void test1() {
        // input
        int[] nums = new int[]{1, 1, 2};

        // expected result
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(2, 1, 1)));
        expected.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
        expected.add(new ArrayList<>(Arrays.asList(1, 1, 2)));

        // call func to get actual result
        for (PermutationsII testObj : _testObjs) {
            List<List<Integer>> rst = testObj.permuteUnique(nums);
            verify(expected, rst);
        }
    }


    @Test
    public void test2() {
        // input
        int[] nums = new int[]{2, 2, 1, 1};

        // expected result
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(2, 1, 1)));
        expected.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
        expected.add(new ArrayList<>(Arrays.asList(1, 1, 2)));

        // call func to get actual result
        for (PermutationsII testObj : _testObjs) {
            List<List<Integer>> rst = testObj.permuteUnique(nums);
            verify(expected, rst);
        }
    }
}
