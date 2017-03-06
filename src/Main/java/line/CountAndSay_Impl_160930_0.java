package line;

/**
 * Created by patrickyu on 9/30/16.
 *
 * 第15行, 明明讨论好了所有情况, 为什么 左右调换了顺序就还是?
 * 答: 因为这个地方你并没有考虑全集的问题.
 *
 */
public class CountAndSay_Impl_160930_0 extends CountAndSay_Abstract {
    public String countAndSay(int n) {

        checkInput(n);

        // 1
        String s = "1";

        // 2:n
        for (int j = 2; j <= n; j++) {
            StringBuilder sb = new StringBuilder();
            int start = 0;

            for (int i = 1; i <= s.length(); i++) {
                if ((i != s.length() && s.charAt(i) != s.charAt(i - 1)) || i == s.length()) {
//                    if (s.charAt(i) != s.charAt(i - 1) || i == s.length()) {
                    // 这样位置调换一下才能避免, s.length() == 1 的情况
                    sb.append(i - start);
                    sb.append(s.charAt(i - 1));
                    start = i;
                }
            }

            s = sb.toString();
        }
        return s;
    }
}

