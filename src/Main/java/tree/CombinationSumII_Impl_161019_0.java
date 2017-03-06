package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrickyu on 10/19/16.
 */
public class CombinationSumII_Impl_161019_0 implements CombinationSumII {
    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> rst = new ArrayList<>();

        Arrays.sort(candidates);
        for (int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            List<List<Integer>> tmpRst = helper(i, target - candidates[i], candidates, new boolean[candidates.length]);
            rst.addAll(tmpRst);
        }

        return rst;
    }


    private List<List<Integer>> helper(int pos, int remain, int[] candidates, boolean[] visitted) {

        List<List<Integer>> rst = new ArrayList<>();

        if (remain == 0 && !visitted[pos]) {
            rst.add(new LinkedList<>(Arrays.asList(candidates[pos])));
            return rst;
        }

        visitted[pos] = true;

        for (int posChild = 0; posChild < candidates.length; posChild++) {

            int remainChild = remain - candidates[posChild];
            if (visitted[posChild]
                    || remainChild < 0
                    || candidates[posChild] < candidates[pos]
                    || (posChild > 0 && candidates[posChild] == candidates[posChild - 1] && !visitted[posChild] && !visitted[posChild - 1])) {
                continue;
            }

            List<List<Integer>> rstChild = helper(posChild, remainChild, candidates, visitted);

            for (List<Integer> child : rstChild) {
                child.add(0, candidates[pos]);
            }

            rst.addAll(rstChild);

        }

        visitted[pos] = false;

        return rst;
    }


    @Test
    public void test() {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;

//        Arrays.sort(candidates);

//        System.out.println(helper(1, target - candidates[1], candidates, new boolean[7]));

//        System.out.println(combinationSum2(candidates, target));


        candidates = new int[]{2, 2, 2};
        target = 4;
        System.out.println(combinationSum2(candidates, target));
    }
}
