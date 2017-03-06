package line;

/**
 * Created by patrickyu on 9/30/16.
 */
public class CountAndSay_Impl_160930_1 extends CountAndSay_Abstract {
    public String countAndSay(int n) {
        checkInput(n);

        // 1
        String s = "1";

        // 2:n
        for (int j = 2; j <= n; j++) {
            StringBuilder sb = new StringBuilder();
            int start = 0;

            for (int i = 1; i <= s.length(); i++) {
                if ( i == s.length() || s.charAt(i) != s.charAt(i - 1) ) {
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
