package line;

import java.util.Arrays;

/**
 * Created by patrickyu on 10/6/16.
 * 这题跟最难的那题有异曲同工的感觉, 但是始终把握不好 base case, 这个需要重要问老师
 */
public class LongestPalindromicSubstring_Impl_161006_0 implements LongestPalindromicSubstring {

    @Override
    public String longestPalindrome(String s) {

        if (s.length() == 1){
            return s;
        }

        int[] start = new int[s.length() + 1];
        for (int i = -1; i < s.length(); i++) {
            start[i + 1] = i;
        }

        String rst = "";

        if (s.charAt(1) == s.charAt(0)) {
            start[2] = start[1];
            rst = s.substring(0, 2);
        }




        for (int i = 2; i < s.length(); i++) {
            if (start[i] - 1 >= 0 && start[i] != i) {
                if (s.charAt(start[i] - 1) == s.charAt(i)) {
                    start[i + 1] = start[i] - 1;
                } else {
                    int left = start[i];
                    while (left <= i && !isPanlindrom(s.substring(left, i + 1))) {
                        left++;
                    }
                    start[i + 1] = left;
                }
            }

            if (rst.equals("") || i - start[i + 1] + 1 > rst.length()) {
                rst = s.substring(start[i + 1], i + 1);
            }
        }
        System.out.println(Arrays.toString(start));
        return rst;
    }

    private boolean isPanlindrom(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }

        return s.charAt(left) == s.charAt(right);
    }

}
