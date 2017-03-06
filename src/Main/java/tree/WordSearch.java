package tree;

import java.util.List;

/**
 * Created by patrickyu on 10/18/16.
 */
public interface WordSearch {

    class Pos {
        int _x;
        int _y;

        public Pos(int x, int y) {
            _x = x;
            _y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pos pos = (Pos) o;

            if (_x != pos._x) return false;
            return _y == pos._y;

        }

        @Override
        public int hashCode() {
            int result = _x;
            result = 31 * result + _y;
            return result;
        }
    }

    public boolean exist(char[][] board, String word);

    public List<List<Pos>> wordSearch(char[][] board, String word);


}
