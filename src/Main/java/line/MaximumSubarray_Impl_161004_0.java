package line;

/**
 * Created by patrickyu on 10/4/16.
 * 这个 test case 是正确的, 但是 leetcode 觉得你做的太慢了,
 * 这里关键的地方在
 */
public class MaximumSubarray_Impl_161004_0 implements MaximumSubarray {
    @Override
    public int maxSubArray(int[] nums) {
        // i = 0
        int maxSum = nums[0];
        int start = 0;

        // i = 1: n-1
        for(int i=1; i< nums.length; i++){
            int localMaxSum = 0;
            int sumFromStartToI = 0;
            for(int j=start; j<=i; j++){
                sumFromStartToI += nums[j];
            }

            if(nums[i] > sumFromStartToI){
                start = i;
                localMaxSum = nums[i];
            }else{
                localMaxSum = sumFromStartToI;
            }

            maxSum = Math.max(maxSum, localMaxSum);
        }
        return maxSum;
    }



}
