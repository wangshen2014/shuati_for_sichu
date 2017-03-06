package line;

import org.junit.Test;

/**
 * Created by patrickyu on 10/29/16.
 */
public class MaximumSizeSubarraySumEqualsK_Impl_161029_0 implements MaximumSizeSubarraySumEqualsK {
    @Override
    public int maxSubArrayLen(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int localSum = nums[0];
        int maxLen = 1;
        int start = 0;


        for (int i = 1; i < nums.length; i++) {
            int newLocalSum = localSum + nums[i];

            while (Math.abs(newLocalSum - nums[start] - k) < Math.abs(newLocalSum - k)) {
                newLocalSum  -= nums[start];
                start++;
            }

            if (newLocalSum == k){
                maxLen = Math.max(maxLen, i - start + 1);
            }
        }

        return maxLen;
    }

    @Test
    public void test(){
        int[] nums = new int[]{1, -1, 5, -2, 3};

        System.out.println(maxSubArrayLen(nums, 3));

    }
}
