package line;

import java.util.HashMap;

/**
 * Created by patrickyu on 10/3/16.
 */
public class TwoSum_impl_161003_0 implements TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                rst[0] = map.get(target - nums[i]);
                rst[1] = i;
                return rst;
            } else {
                map.put(nums[i], i);
            }
        }

        return rst;
    }
}
