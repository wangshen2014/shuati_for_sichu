package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by patrickyu on 10/16/16.
 * 这种写法是方便理解的,
 */
public class GenerateParentheses_Impl_161016_0 implements GenerateParentheses {

    @Override
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("invalid input");
        }

        return helper("(", 1, 0, n);
    }

    private List<String> helper(String par, int leftNum, int rightNum, int n) {
        if (leftNum == n && rightNum == n) {
            return new ArrayList<>(Arrays.asList(")"));
        }


        List<String> rst = new ArrayList<>();

        if (leftNum < n) {
            List<String> leftRst = helper("(", leftNum + 1, rightNum, n);
            rst.addAll(leftRst.stream().map(s -> par + s).collect(Collectors.toList()));
        }

        if (leftNum > rightNum) {
            List<String> rightRst = helper(")", leftNum, rightNum + 1, n);
            for (String s : rightRst) {
                rst.add(par + s);
            }
        }

        return rst;
    }

}
