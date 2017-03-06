package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by patrickyu on 10/23/16.
 * 这是用的 DFS 的做法
 */
public class NQueens_Impl_161023_0 implements NQueens {

    class Node {
        int _col;
        int _height;

        public Node(int col, int height) {
            _col = col;
            _height = height;
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> rst = new ArrayList<>();

        for (int col = 0; col < n; col++) {

            int[] cols = new int[n];
            Stack<Node> stack = new Stack<>();
            stack.push(new Node(col, 0));

            while (!stack.isEmpty()) {
                Node cur = stack.pop();

                cols[cur._height] = cur._col;

                if (cur._height == n - 1) {
                    rst.add(draw(cols));
                }


                for (int colChild = 0; colChild < n; colChild++) {
                    int heightChild = cur._height + 1;
                    boolean isValid = true;
                    for (int prevHeight = 0; prevHeight <= cur._height; prevHeight++) {
                        if (colChild == cols[prevHeight] ||
                                colChild == cols[prevHeight] + (heightChild - prevHeight) ||
                                colChild == cols[prevHeight] - (heightChild - prevHeight)
                                ) {
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid) {
                        stack.push(new Node(colChild, heightChild));
                    }

                }
            }
        }

        return rst;
    }

    private List<String> draw(int[] cols) {
        int n = cols.length;
        List<String> rst = new ArrayList<>();

        char[] row = new char[n];
        Arrays.fill(row, '.');

        for (int i = 0; i < n; i++) {
            row[cols[i]] = 'Q';
            rst.add(new String(row));
            row[cols[i]] = '.';

        }
        return rst;
    }


    @Test
    public void test() {
//        List<List<Integer>> cols = new ArrayList<>();
//        List<Integer> ans1 = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
//        List<Integer> ans2 = new ArrayList<>(Arrays.asList(1, 3, 0, 2));
//        cols.add(ans1);
//        cols.add(ans2);
//
//        System.out.println(draw(cols, 4));

        System.out.println(solveNQueens(2));
    }
}
