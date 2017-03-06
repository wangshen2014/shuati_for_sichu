import org.junit.Test;

import java.util.*;

/**
 * Created by patrickyu on 9/30/16.
 */
public class _Main {


    private class Node {
        int _curSum;
        int _val;
        int _height;

        public Node(int val, int curSum, int height) {
            _val = val;
            _curSum = curSum;
            _height = height;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "_curSum=" + _curSum +
                    ", _val=" + _val +
                    ", _height=" + _height +
                    '}';
        }
    }

    public int combinationSum4(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int rst = 0;

        for (int i = 0; i < nums.length; i++) {


            Stack<Node> stack = new Stack<>();
            stack.push(new Node(nums[i], nums[i], 0));


            while (!stack.isEmpty()) {
                Node cur = stack.pop();




                if (cur._curSum == target) {
                    rst++;

                }

                for (int j = nums.length - 1; j >= 0; j--) {
                    if (cur._curSum + nums[j] <= target) {
                        stack.push(new Node(nums[j], cur._curSum + nums[j], cur._height + 1));
                    }
                }


            }

        }

        return rst;
    }


    @Test
    public void test() {

        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }


}
