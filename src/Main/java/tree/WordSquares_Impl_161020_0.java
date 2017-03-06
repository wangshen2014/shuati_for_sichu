package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrickyu on 10/20/16.
 * 做出来了, 时间没过...哎算了, 尽力了
 */
public class WordSquares_Impl_161020_0 implements WordSquares {

    @Override
    public List<List<String>> wordSquares(String[] words) {

        List<List<String>> rst = new ArrayList<>();

        char[][] square = new char[words[0].length()][words[0].length()];

        for (int i = 0; i < words.length; i++) {
            List<List<String>> rstChild = helper(square, words, 0, i);
            rst.addAll(rstChild);
        }

        return rst;
    }


    private List<List<String>> helper(char[][] square, String[] words, int pos, int index) {
        List<List<String>> rst = new ArrayList<>();

        if (pos == square.length - 1 && canAddWord(square, words[index], pos)) {
            addWord(square, words[index], pos);

            List<String> tmpRst = new LinkedList<>();
            for (char[] row : square) {
//                System.out.println(Arrays.toString(row));
                tmpRst.add(new String(row));
            }
            rst.add(tmpRst);
            return rst;
        }

        addWord(square, words[index], pos);


        for (int indexChild = 0; indexChild < words.length; indexChild++) {

            int posChild = pos + 1;
            if (!canAddWord(square, words[indexChild], posChild)) {
                continue;
            }
            rst.addAll(helper(square, words, posChild, indexChild));

        }


        unAddWord(square, words[index], pos);

        return rst;
    }

    private boolean canAddWord(char[][] square, String word, int pos) {
        square[pos][pos] = word.charAt(pos);
        boolean rst = true;
        for (int i = 0; i <= pos; i++) {
            if (square[pos][i] != word.charAt(i)) {
                rst = false;
                break;
            }
        }

        square[pos][pos] = 0;
        return rst;
    }

    private void addWord(char[][] square, String word, int pos) {

        // add word
        for (int i = pos; i < word.length(); i++) {
            square[pos][i] = word.charAt(i);
            square[i][pos] = word.charAt(i);
        }

    }

    private void unAddWord(char[][] square, String word, int pos) {
        // un add word
        for (int i = pos; i < word.length(); i++) {
            square[pos][i] = 0;
            square[i][pos] = 0;
        }
    }

    @Test
    public void test() {
        String[] words = new String[]{"a"};
        char[][] square = new char[words[0].length()][words[0].length()];

        System.out.println(wordSquares(words));
    }

    @Test
    public void test1() {
        String[] words = new String[]{"area", "lead", "wall", "lady", "ball"};
        char[][] square = new char[words[0].length()][words[0].length()];

        System.out.println(wordSquares(words));
    }

    @Test
    public void test2() {
        String[] words = new String[]{"abat", "baba", "atan", "atal"};
        char[][] square = new char[words[0].length()][words[0].length()];

        System.out.println(wordSquares(words));
    }

}
