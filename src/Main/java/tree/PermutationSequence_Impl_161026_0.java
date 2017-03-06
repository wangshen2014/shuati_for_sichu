package tree;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by patrickyu on 10/26/16.
 */
public class PermutationSequence_Impl_161026_0 implements PermutationSequence {

    class Node {
        int _height;
        int _val;
        int _order;

        public Node(int val, int height, int order) {
            _val = val;
            _height = height;
            _order = order;
        }
    }

    @Override
    public String getPermutation(int n, int k) {


        int[] pathVal = new int[n + 1];
        int[] pathOrder = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Stack<Node> stack = new Stack<>();
        visited[0] = true;
        pathOrder[0] = 1;

        stack.push(new Node(0, 0, 1));
        int prevHeight = 0;

        while (!stack.isEmpty()) {
            Node cur = stack.pop();


            for (int i = prevHeight; i <= cur._height; i++) {
                visited[i] = false;
            }

            pathVal[cur._height] = cur._val;

            visited[cur._height] = true;
            prevHeight = cur._height;


            if (cur._height == n - 1 && cur._order == k) {
                StringBuilder sb = new StringBuilder();

                for (int i = 1; i <= cur._height; i++) {
                    sb.append(pathVal[i]);
                }
                return sb.toString();
            }

            for (int valChild = 1; valChild <= n; valChild++) {
                int heightChild = cur._height + 1;

                if (!visited[valChild]) {

                    pathOrder[heightChild] = pathOrder[heightChild] + 1;
                    if (pathOrder[heightChild] == k) {
                        stack.push(new Node(valChild, heightChild, pathOrder[heightChild]));

                    }

                }
            }
        }


        return null;
    }


    @Test
    public void test() {

        System.out.println(getPermutation(3, 6));
    }
}
