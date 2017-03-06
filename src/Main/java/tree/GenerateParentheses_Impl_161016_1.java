package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by patrickyu on 10/16/16.
 *
 */
public class GenerateParentheses_Impl_161016_1 implements GenerateParentheses {
    @Override
    public List<String> generateParenthesis(int n) {

        List<String> rst = helper("(", 1, 0, n).stream().map(sb -> sb.reverse().toString()).collect(Collectors.toList());
        return rst;
    }

    private List<StringBuilder> helper(String cur, int leftNum, int rightNum, int n) {


        List<StringBuilder> rst = new ArrayList<>();
        if (leftNum < n) {
            List<StringBuilder> leftRst = helper("(", leftNum + 1, rightNum, n);
            for (StringBuilder sb : leftRst) {
                rst.add(sb.append(cur));
            }
        }

        if (rightNum < leftNum) {
            List<StringBuilder> rightRst = helper(")", leftNum, rightNum + 1, n);
            rst.addAll(rightRst.stream().map(sb -> sb.append(cur)).collect(Collectors.toList()));
        }

        if (leftNum == n && rightNum == n) {
            return new ArrayList<>(Arrays.asList(new StringBuilder(")")));
        }

        return rst;

    }
}
