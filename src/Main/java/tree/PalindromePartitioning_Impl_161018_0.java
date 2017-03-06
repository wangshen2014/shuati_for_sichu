package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by patrickyu on 10/18/16.
 */
public class PalindromePartitioning_Impl_161018_0 implements PalindromePartitioning {
    @Override
    public List<List<String>> partition(String s) {
        return null;
    }


    private List<List<String>> helper(String s, int start, int end) {

        List<List<String>> rst = new ArrayList<>();

        if (end == s.length() - 1 && isPalindrome(s.substring(start, end + 1))) {
            List<String> tmpRst = new LinkedList<>();
            tmpRst.add(s.substring(start, end + 1));
            rst.add(tmpRst);
            return rst;
        }


        for (int startChild = end + 1; startChild < s.length(); startChild += end - start + 1) {

            int endChild = startChild + end - start;

            if (endChild >= s.length()) {
                endChild = s.length() - 1;
            }

            if (startChild < endChild && isPalindrome(s.substring(startChild, endChild + 1))) {

                List<List<String>> rstChild = helper(s, startChild, endChild);

                for (List<String> child : rstChild) {
                    child.add(0, s.substring(start, end + 1));
                }
                rst.addAll(rstChild);
            }
        }
        return rst;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {

            char c1 = s.charAt(left);
            char c2 = s.charAt(right);
            if (c1 != c2) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void test() {

        System.out.println(helper("aab", 0, 1));
    }
}
