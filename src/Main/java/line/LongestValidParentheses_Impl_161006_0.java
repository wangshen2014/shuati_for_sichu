package line;

/**
 * Created by patrickyu on 10/6/16.
 * <p>
 * 这道题是面试前提下最难的算法了,没有之一
 * <p>
 * 这道题实际上有 13 个 condition, 因为这个结果是你 combine 了之后的算法, 具体的解释跟推导你看看笔记就好了, 只要推对了
 * 这个算法写起来也只有下面这里一点点
 */
public class LongestValidParentheses_Impl_161006_0 implements LongestValidParentheses {
    @Override
    public int longestValidParentheses(String s) {
        int[] start = new int[s.length() + 1];
        for (int i = -1; i < s.length(); i++) {
            start[i + 1] = i + 1;
        }

        int rst = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    start[i + 1] = start[i - 1];
                    rst = Math.max(rst, i - start[i + 1] + 1);
                } else if (start[i] > 0 && s.charAt(start[i] - 1) == '(') {
                    start[i + 1] = start[start[i] - 1];
                    rst = Math.max(rst, i - start[i + 1] + 1);
                }
            }
        }
        return rst;
    }
}
