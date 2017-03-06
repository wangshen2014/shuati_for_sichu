package tree;

import java.util.List;

/**
 * Created by patrickyu on 10/18/16.
 */
public class WordSearch_Impl_161018_0 implements WordSearch {

    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] directions = new int[][]{new int[]{0, 1}, new int[]{1, 0}, new int[]{0, -1}, new int[]{-1, 0}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(i, j, 0, word, visited, board, directions)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<List<Pos>> wordSearch(char[][] board, String word) {
        return null;
    }

    private boolean helper(int row, int col, int pos, String word, boolean[][] visited, char[][] board, int[][] directions) {
        if (pos == word.length() - 1 && !visited[row][col] && word.charAt(pos) == board[row][col]) {
            return true;
        }

        visited[row][col] = true;

        int posChild = pos + 1;

        for (int[] dir : directions) {
            int rowChild = row + dir[0];
            int colChild = col + dir[1];

            if (rowChild >= 0 && rowChild < board.length &&
                    colChild >= 0 && colChild < board[0].length &&
                    posChild < word.length() && !visited[rowChild][colChild] &&
                    word.charAt(posChild) == board[rowChild][colChild]) {

                if (helper(rowChild, colChild, posChild, word, visited, board, directions)) {
                    return true;
                }
            }
        }

        visited[row][col] = false;
        return false;
    }
}
