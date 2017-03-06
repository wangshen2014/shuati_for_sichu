package line;

/**
 * Created by patrickyu on 9/30/16.
 * 这个算法是解决了 _ _ the _ sky _ is _ blue _ _ _ 的这种情况
 * 这个算法是从右往左边来推导的
 */
public class ReverseWordsInAString_Impl_160930_1 implements ReverseWordsInAString {

    public String reverseWords(String s) {
        int end = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        String prefix = "";


        for (int i = s.length() - 1; i >= -1; i--) {

            if ((i > -1 && s.charAt(i) == ' ') || i == -1) {
                if (i != end) {
                    sb.append(prefix + s.substring(i + 1, end + 1));
                    prefix = " ";
                }
                end = i - 1;
            }

        }

        return sb.toString();
    }
}
