package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrickyu on 10/18/16.
 */
public class PermutationsII_Impl_161018_0 implements PermutationsII {
    @Override
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> tmpRst = helper(i, 1, nums, new boolean[nums.length]);
            rst.addAll(tmpRst);

        }
        return rst;
    }


    public List<List<Integer>> helper(int pos, int len, int[] nums, boolean[] visited) {
        List<List<Integer>> rst = new ArrayList<>();


        if (len == nums.length) {
            List<Integer> tmp = new LinkedList<>();
            tmp.add(nums[pos]);
            rst.add(tmp);
            return rst;
        }

        visited[pos] = true;

        for (int posChild = 0; posChild < nums.length; posChild++) {
            if (visited[posChild] || posChild > 0 && nums[posChild] == nums[posChild - 1] && !visited[posChild - 1]) {
                continue;
            }

            List<List<Integer>> rstChild = helper(posChild, len + 1, nums, visited);
            for (List<Integer> list : rstChild) {
                list.add(0, nums[pos]);
            }
            rst.addAll(rstChild);


        }

        visited[pos] = false;
        return rst;
    }

    @Test
    public void test() {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));

    }
}
