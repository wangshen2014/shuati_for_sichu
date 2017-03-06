package line;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by patrickyu on 10/2/16.
 */
public class Test_Subsets {
    Subsets[] _testObjs = new Subsets[]{
            new Subsets_Impl_121002_0(),
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
        int[] nums = new int[]{1, 2, 3};

        // expected result
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList());
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(2));
        expected.add(Arrays.asList(1, 2));
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(1, 3));
        expected.add(Arrays.asList(2, 3));
        expected.add(Arrays.asList(1, 2, 3));


        // call func to get actual result
        for (Subsets testObj : _testObjs) {
            List<List<Integer>> rst = testObj.subsets(nums);
            verify(expected, rst);
        }
    }
}
