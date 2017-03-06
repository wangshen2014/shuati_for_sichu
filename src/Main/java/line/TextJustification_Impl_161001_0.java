package line;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrickyu on 10/1/16.
 */
public class TextJustification_Impl_161001_0 implements TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {

        // aux variable
        List<String> rst = new ArrayList<String>();
        int start = 0;
        int count = words[0].length();

        // 1:n
        for (int i = 1; i <= words.length; i++) {

            if (i != words.length) {
                count += words[i].length() + 1;
            }

            // [4]
            if (i == words.length) {
                count = 0;
                rst.add(reformat(words, start, i - 1, count, maxWidth));
            }

            // [3]
            if (count > maxWidth) {
                count -= count - words[i].length();
                rst.add(reformat(words, start, i - 1, count, maxWidth));
                count = words[i].length();
                start = i;
            }

        }
        return rst;
    }


    public String reformat(String[] words, int from, int to, int count, int width) {

        StringBuilder sb = new StringBuilder();
        String prefix = "";

        if (count <= width && to == words.length-1) {

            for (int i = from; i <= to; i++) {
                if (i != to) {
                    sb.append(prefix + words[i]);
                    prefix = " ";
                } else {
                    sb.append(prefix + words[i]).append(nSpace(width - sb.length()));
                }
            }
            return sb.toString();
        } else {
            int numOfspaceSpot = to - from;
            int numOfspacesForOneSpot = (int) Math.ceil((width - count + numOfspaceSpot) / (double) numOfspaceSpot);
            for (int i = from; i <= to; i++) {
                sb.append(prefix + words[i]);
                if (i + 1 < words.length && i + 1 != to) {
                    prefix = nSpace(numOfspacesForOneSpot);
                } else if (i + 1 < words.length) {
                    prefix = nSpace(width - sb.length() - words[i + 1].length());
                }
            }
        }



        return sb.toString();
    }


    public String nSpace(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String[] s = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 12;


        s = new String[]{"What", "must", "be", "shall", "be."};
        System.out.println(fullJustify(s, 12));
    }
}
