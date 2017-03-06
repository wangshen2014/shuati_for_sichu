package tree;

import java.util.List;

/**
 * Created by patrickyu on 10/29/16.
 */
public interface BinaryTreeVerticalOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root);

}
