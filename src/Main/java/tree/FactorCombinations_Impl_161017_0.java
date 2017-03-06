package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrickyu on 10/17/16.
 */
public class FactorCombinations_Impl_161017_0 implements FactorCombinations {
    @Override
    public List<List<Integer>> getFactors(int n) {
        return helper(1, n);
    }


    private List<List<Integer>> helper(int left, int right) {

        List<List<Integer>> rst = new ArrayList<>();

        // left, right -> result
        if (left != 1) {
            rst.add(new LinkedList<>(Arrays.asList(left, right)));
        }

        // left, each of right -> result
        for (int i = 2; i <= Math.sqrt(right); i++) {
            int leftChild = i;
            int rightChild = right / leftChild;
            if (rightChild * leftChild == right && leftChild >= left) {
                List<List<Integer>> rstChild = helper(leftChild, rightChild);

                for (List<Integer> list : rstChild) {
                    if (left != 1) {
                        list.add(0, left);
                    }
                    rst.add(list);
                }
            }
        }
        return rst;

    }
}
