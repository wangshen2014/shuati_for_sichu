package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrickyu on 10/19/16.
 */
public class CombinationSumIII_Impl_161019_0 implements CombinationSumIII {

    @Override
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> rst = new ArrayList<>();
        boolean[] visited = new boolean[10];

        for (int i = 1; i <= 9; i++) {
            List<List<Integer>> tmpRst = helper(i, 1, n - i, visited, k);
            rst.addAll(tmpRst);
        }


        return rst;
    }


    private List<List<Integer>> helper(int cur, int len, int remain, boolean[] visited, int k) {

        List<List<Integer>> rst = new ArrayList<>();

        if (remain == 0 && !visited[cur] && len == k) {
            rst.add(new LinkedList<>(Arrays.asList(cur)));
        }


        visited[cur] = true;


        for (int curChild = 1; curChild <= 9; curChild++) {
            int remainChild = remain - curChild;
            int lenChild = len + 1;
            if (visited[curChild] || remainChild < 0 || lenChild > k || curChild < cur) {
                continue;
            }


            List<List<Integer>> rstChild = helper(curChild, lenChild, remainChild, visited, k);

            for (List<Integer> child : rstChild) {
                child.add(0, cur);
            }
            rst.addAll(rstChild);
        }


        visited[cur] = false;
        return rst;
    }


    @Test
    public void test() {
        System.out.println(combinationSum3(3, 9));
    }
}
