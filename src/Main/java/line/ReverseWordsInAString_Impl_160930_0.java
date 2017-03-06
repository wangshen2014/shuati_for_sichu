package line;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by patrickyu on 9/30/16.
 * 这道题是没有考虑 前面或者后面 会出现 space 的算法
 *
 * 186. Reverse Words in a String II
 * 会跟这道题很接近
 */
public class ReverseWordsInAString_Impl_160930_0 implements ReverseWordsInAString {

    public String reverseWords(String s) {
        if (s.trim().length() == 0) {
            return "";
        }

        s += " ";

        LinkedList<String> rst = new LinkedList<String>();
        int start = 0;

        for (int i = 1; i < s.length(); i++) {
            String tmp = "";

            if (s.charAt(i) == ' ') {
                tmp = s.substring(start, i + 1);
                start = i + 1;
            }

            rst.addFirst(tmp);
        }

        StringBuilder rstStr = new StringBuilder();
        Iterator<String> iter = rst.iterator();
        while (iter.hasNext()) {
            rstStr.append(iter.next());
        }

        return rstStr.toString().substring(0, rstStr.length() - 1);

    }
}
