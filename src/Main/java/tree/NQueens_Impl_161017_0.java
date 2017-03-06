package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrickyu on 10/17/16.
 */
public class NQueens_Impl_161017_0 implements NQueens {
    @Override
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> rst = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            rst.addAll(helper(0, i, new boolean[n][n]));
        }
        return rst;
    }

    private List<List<String>> helper(int row, int col, boolean[][] visited) {
        List<List<String>> rst = new ArrayList<>();
        if (row == visited.length - 1) {
            rst.add(new LinkedList<>(Arrays.asList(queenRow(col, visited.length))));
            return rst;
        }
        // visit position
        visited[row][col] = true;

        int rowChild = row + 1;
        for (int colChild = 0; colChild < visited.length; colChild++) {
            if (isValid(rowChild, colChild, visited)) {
                List<List<String>> childRst = helper(rowChild, colChild, visited);
                for (List<String> child : childRst) {
                    child.add(0, queenRow(col, visited.length));

                }
                rst.addAll(childRst);
            }
        }
        // un-visit position
        visited[row][col] = false;
        return rst;
    }


    private boolean isValid(int row, int col, boolean[][] visited) {
        for (int i = 1; i < visited.length; i++) {
            if (row - i >= 0 && visited[row - i][col]) {
                return false;
            }
            if (row - i >= 0 && col + i < visited.length && visited[row - i][col + i]) {
                return false;
            }
            if (row - i >= 0 && col - i >= 0 && visited[row - i][col - i]) {
                return false;
            }
        }
        return true;
    }

    private String queenRow(int col, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == col) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }


    @Test
    public void test() {
        boolean[][] visited = new boolean[5][5];
        System.out.println(helper(0, 0, visited));

//        System.out.println(solveNQueens(4));
    }
}
