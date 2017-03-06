package treeBFS;

import java.util.*;

/**
 * Created by patrickyu on 10/30/16.
 * 这个是 google 原题
 */
public class PerfectSquares_Impl_161030_0 implements PerfectSquares {

    private class Node {
        int _index;
        int _right;
        Node _parent;

        public Node(int index, int right, Node parent) {
            _index = index;
            _right = right;
            _parent = parent;
        }
    }

    @Override
    public List<List<Integer>> numSquares(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("invalid input");
        }

        List<Integer> nums = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
            nums.add(i * i);
            set.add(i * i);
        }


        return null;
    }

    private List<Node> buildTree(int n, List<Integer> nums, Set<Integer> set) {

        return null;
    }

    private List<List<Integer>> walkTree(List<Node> endNodes) {

        return null;
    }
}
