package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by patrickyu on 10/15/16.
 */
public class Test_TheSkylineProblem {

    TheSkylineProblem[] _testObjs = new TheSkylineProblem[]{
            new TheSkylineProblem_Impl_161015_0(),
    };

    private void verify(List<int[]> expected, List<int[]> actual) {
        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i)[0], actual.get(i)[0]);
            assertEquals(expected.get(i)[1], actual.get(i)[1]);
        }
    }

    @Test
    public void test1() {
        // input
        int[][] buildings = new int[][]{
                new int[]{2, 9, 10},
                new int[]{3, 7, 15},
                new int[]{5, 12, 12},
                new int[]{15, 20, 10},
                new int[]{19, 24, 8}};

        // expected result
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{2, 10});
        expected.add(new int[]{3, 15});
        expected.add(new int[]{7, 12});
        expected.add(new int[]{12, 0});
        expected.add(new int[]{15, 10});
        expected.add(new int[]{20, 8});
        expected.add(new int[]{24, 0});

        // call func to get actual result
        for (TheSkylineProblem testObj : _testObjs) {
            List<int[]> actual = testObj.getSkyline(buildings);
            verify(expected, actual);
        }
    }

    @Test
    public void test2() {
        // input
        int[][] buildings = new int[][]{
                new int[]{0, 2, 3},
                new int[]{2, 5, 3}
        };

        // expected result
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{0, 3});
        expected.add(new int[]{5, 0});


        // call func to get actual result
        for (TheSkylineProblem testObj : _testObjs) {
            List<int[]> actual = testObj.getSkyline(buildings);
            verify(expected, actual);
        }
    }

    @Test
    public void test3() {
        // input
        int[][] buildings = new int[][]{
                new int[]{1, 2, 1},
                new int[]{1, 2, 2},
                new int[]{1, 2, 3}

        };

        // expected result
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{1, 3});
        expected.add(new int[]{2, 0});


        // call func to get actual result
        for (TheSkylineProblem testObj : _testObjs) {
            List<int[]> actual = testObj.getSkyline(buildings);
            verify(expected, actual);
        }
    }
}
