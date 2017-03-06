package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrickyu on 10/18/16.
 */
public class Combinations_Impl_161018_0 implements Combinations {

    @Override
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<List<Integer>> tmpRst = helper(1, i, n, k);
            rst.addAll(tmpRst);
        }

        return rst;
    }


    private List<List<Integer>> helper(int len, int cur, int n, int k) {

        List<List<Integer>> rst = new ArrayList<>();
        if (len == k) {
            List<Integer> tmpRst = new LinkedList<>();
            tmpRst.add(0, cur);
            rst.add(tmpRst);
            return rst;
        }


        for (int curChild = 1; curChild <= n; curChild++) {
            if (curChild == cur) continue;

            if (curChild > cur) {
                List<List<Integer>> rstChild = helper(len + 1, curChild, n, k);

                for (List<Integer> child : rstChild) {
                    child.add(0, cur);
                }
                rst.addAll(rstChild);
            }
        }

        return rst;
    }


    @Test
    public void test() {
        System.out.println(combine(4, 2));
    }
}
