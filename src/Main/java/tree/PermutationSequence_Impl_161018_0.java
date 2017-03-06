package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrickyu on 10/18/16.
 */
public class PermutationSequence_Impl_161018_0 implements PermutationSequence {
    @Override
    public String getPermutation(int n, int k) {


        int totalCount = 1;
        for (int i = n; i >= 1; i--) {
            totalCount *= i;
        }
        int perCount = totalCount / n;

        int rstIndex = k - 1 % perCount;

        StringBuilder nSb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            nSb.append("" + i);
        }

        String nStr = nSb.toString();


        List<StringBuilder> tmpRst = helper(nStr, 0, 1, new boolean[n]);



        return tmpRst.get(rstIndex).reverse().toString();
    }


    private List<StringBuilder> helper(String s, int pos, int len, boolean[] visited) {

        List<StringBuilder> rst = new ArrayList<>();

        if (len == s.length() && !visited[pos]) {
            StringBuilder sb = new StringBuilder();
            sb.append("" + s.charAt(pos));
            rst.add(sb);
            return rst;
        }


        visited[pos] = true;

        for (int posChild = 0; posChild < s.length(); posChild++) {

            if (!visited[posChild]) {
                List<StringBuilder> rstChild = helper(s, posChild, len + 1, visited);

                for (StringBuilder child : rstChild) {
                    child.append("" + s.charAt(pos));
                }
                rst.addAll(rstChild);
            }
        }

        visited[pos] = false;
        return rst;
    }


    @Test
    public void test() {

        System.out.println(getPermutation(3, 5));
//        int n = 3;
//
//        int totalCount = 1;
//        int perCount = 0;
//        for (int i = n; i >= 1; i--) {
//            totalCount *= i;
//        }
//        perCount = totalCount / n;
//        System.out.println(perCount);
    }
}
