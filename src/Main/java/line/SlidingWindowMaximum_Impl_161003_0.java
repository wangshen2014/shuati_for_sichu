package line;

import java.util.LinkedList;

/**
 * Created by patrickyu on 10/3/16.
 */
public class SlidingWindowMaximum_Impl_161003_0 implements SlidingWindowMaximum {
    @Override
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        LinkedList<Integer> list = new LinkedList<>();
        int[] rst = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[i] > nums[list.getLast()]) {
                list.removeLast();
            }
            if (!list.isEmpty() && i - k == list.getFirst()) {
                list.removeFirst();
            }
            list.add(i);

            if (i + 1 >= k) {
                rst[j++] = nums[list.getFirst()];
            }
        }

        return rst;
    }
}
