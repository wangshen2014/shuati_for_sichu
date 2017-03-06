package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrickyu on 10/18/16.
 */
public class CombinationSum_Impl_161018_0 implements CombinationSum {
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> rst = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            List<List<Integer>> tmpRst = helper(target - candidates[i], i, candidates);
            rst.addAll(tmpRst);
        }

        return rst;
    }


    private List<List<Integer>> helper(int remain, int pos, int[] candidates) {
        List<List<Integer>> rst = new ArrayList<>();

        if (remain == 0) {
            List<Integer> tmpRst = new LinkedList<>();
            tmpRst.add(candidates[pos]);
            rst.add(tmpRst);
            return rst;
        }


        for (int posChild = 0; posChild < candidates.length; posChild++) {
            int remainChild = remain - candidates[posChild];

            if (remainChild >= 0 && candidates[posChild] >= candidates[pos]) {
                List<List<Integer>> rstChild = helper(remainChild, posChild, candidates);

                for (List<Integer> child : rstChild) {
                    child.add(0, candidates[pos]);
                }
                rst.addAll(rstChild);
            }
        }

        return rst;
    }


    @Test
    public void test() {

        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));

    }
}
