package line;

/**
 * Created by patrickyu on 10/4/16.
 */
public class MaximumSubarray_Impl_161004_1 implements MaximumSubarray {
    public int maxSubArray(int[] nums) {

        // i = 0
        int maxSum = nums[0];
        int localMaxSum = nums[0];

        // i = 1: n-1
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > localMaxSum + nums[i]) {
                localMaxSum = nums[i];
            } else {
                localMaxSum += nums[i];
            }

            maxSum = Math.max(maxSum, localMaxSum);
        }
        return maxSum;
    }
}
