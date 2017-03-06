package treeBFS;

import org.junit.Test;

import java.util.*;

/**
 * Created by patrickyu on 10/29/16.
 */
public class NumberOfIslands_Impl_161029_0 implements NumberOfIslands {

    class Node {
        int _row;
        int _col;

        public Node(int row, int col) {
            _row = row;
            _col = col;
        }
    }

    @Override
    public int numIslands(char[][] grid) {

        int rst = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return rst;
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1' && !visited[row][col]) {

                    helperBFS(row, col, visited, dirs, grid);
                    rst++;
                }

            }
        }
        return rst;
    }


    private void helperBFS(int row, int col, boolean[][] visited, int[][] dirs, char[][] grid) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col));

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                visited[cur._row][cur._col] = true;


                for (int[] dir : dirs) {
                    int rowChild = cur._row + dir[0];
                    int colChild = cur._col + dir[1];

                    if (rowChild >= 0 && rowChild < grid.length &&
                            colChild >= 0 && colChild < grid[0].length &&
                            grid[rowChild][colChild] == '1' &&
                            !visited[rowChild][colChild]
                            ) {
                        queue.add(new Node(rowChild, colChild));
                    }
                }

            }
        }
    }

    private void helperDFS(int row, int col, boolean[][] visited, int[][] dirs, char[][] grid) {

        Stack<Node> stack = new Stack<>();
        stack.push(new Node(row, col));

        while (!stack.isEmpty()) {


            Node cur = stack.pop();

            visited[cur._row][cur._col] = true;


            for (int[] dir : dirs) {
                int rowChild = cur._row + dir[0];
                int colChild = cur._col + dir[1];

                if (rowChild >= 0 && rowChild < grid.length &&
                        colChild >= 0 && colChild < grid[0].length &&
                        grid[rowChild][colChild] == '1' &&
                        !visited[rowChild][colChild]
                        ) {
                    stack.push(new Node(rowChild, colChild));
                }
            }
        }
    }


    @Test
    public void test() {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));


        List<Character> list = new ArrayList<>();
        list.add('h');
        list.add('o');
        list.add('l');


    }
}
