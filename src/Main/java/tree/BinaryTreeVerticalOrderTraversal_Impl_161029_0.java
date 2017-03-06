package tree;

import org.junit.Test;

import java.util.*;

/**
 * Created by patrickyu on 10/29/16.
 */
public class BinaryTreeVerticalOrderTraversal_Impl_161029_0 implements BinaryTreeVerticalOrderTraversal {

    @Override
    public List<List<Integer>> verticalOrder(BinaryTreeVerticalOrderTraversal.TreeNode root) {
        List<List<Integer>> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0, 0));

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();


                if (map.containsKey(cur._col)) {
                    map.get(cur._col).add(cur._node.val);
                } else {
                    map.put(cur._col, new ArrayList<>(Arrays.asList(cur._node.val)));
                }


                if (cur._node.left != null) {
                    queue.add(new Node(cur._node.left, cur._col - 1, cur._height));
                }


                if (cur._node.right != null) {
                    queue.add(new Node(cur._node.right, cur._col + 1, cur._height));
                }
            }

        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            rst.add(entry.getValue());
        }


        return rst;
    }


    class Node {
        BinaryTreeVerticalOrderTraversal.TreeNode _node;
        int _col;
        int _height;

        public Node(BinaryTreeVerticalOrderTraversal.TreeNode node, int col, int height) {
            _node = node;
            _col = col;
            _height = height;
        }
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.right.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(5);

        System.out.println(verticalOrder(root));

    }
}
