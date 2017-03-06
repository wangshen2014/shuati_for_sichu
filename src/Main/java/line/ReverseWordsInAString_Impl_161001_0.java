package line;

import org.junit.Test;

/**
 * Created by patrickyu on 10/1/16.
 * 这个算法是从左往右的推导
 */
public class ReverseWordsInAString_Impl_161001_0 implements ReverseWordsInAString {

    public static int property;
    public  String reverseWords(String s) {
        // aux variables
        int start = 0;
        StringBuilder rst = new StringBuilder();
        String prefix = "";

        // 0:n
        for (int i = 0; i <= s.length(); i++) {
            // [3], [4], [1]
            if (i == s.length() || s.charAt(i) == ' ') {
                if (i != start) {

                    // [action] reverse [start -> i-1]
                    StringBuilder tmpSb = new StringBuilder();
                    tmpSb.append(s.substring(start, i));
                    tmpSb.reverse();
                    rst.append(prefix + tmpSb.toString());
                    prefix = " ";
                }

                // [update variable]
                start = i + 1;
            }
        }
        return rst.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(reverseWords("  the sky  is   blue   "));
    }
}

