package tree;

import org.junit.Test;

import java.util.*;

/**
 * Created by patrickyu on 10/26/16.
 *
 * recursion 的做法 (还没想出来怎么做)
 */
public class NQueens_Impl_161026_0 implements NQueens {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> rst = new ArrayList<>();

        for (int col = 0; col < n; col++) {
            int[] cols = new int[n];
//            rst.add(draw(helper(cols, 0, col)));
        }

        return rst;
    }


    private List<List<String>> helper(int[] cols, int row, int col) {

        List<List<String>> rst = new ArrayList<>();


        if (row == cols.length - 1) {
            cols[row] = col;
            rst.add(draw(cols));
            return rst;
        }

        for (int colChild = 0; colChild < cols.length; colChild++) {

            int rowChild = row + 1;
            boolean isValid = true;
            for (int prevRow = 0; prevRow <= row; prevRow++) {
                if (rowChild == cols[prevRow] ||
                        rowChild == cols[prevRow] + (rowChild - prevRow) ||
                        rowChild == cols[prevRow] - (rowChild - prevRow)
                        ) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                cols[rowChild] = colChild;
                List<List<String>> rstChild = helper(cols, rowChild, colChild);
                rst.addAll(rstChild);
            }
        }

        return rst;
    }


    private List<String> draw(int[] cols) {

//        int[] cols = new int[list.size()];
//        Iterator<Integer> iter = list.iterator();
//        int j = 0;
//        while (iter.hasNext()) {
//            cols[j++] = iter.next();
//        }


        int n = cols.length;
        List<String> rst = new ArrayList<>();

        char[] row = new char[n];
        Arrays.fill(row, '.');

        for (int col : cols) {
            row[col] = 'Q';
            rst.add(new String(row));
            row[col] = '.';

        }
        return rst;
    }


    @Test
    public void test() {
        System.out.println(helper(new int[5], 0, 0));
    }
}
