package line;

/**
 * Created by patrickyu on 10/4/16.
 * <p>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray_Impl_161004_0 implements MaximumProductSubarray {

    @Override
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int localMin = nums[0];
        int localMax = nums[0];

        for (int i = 1; i < nums.length; i++) {


            if (nums[i] > 0){
                int newLocalMax = Math.max(nums[i] * localMax, nums[i]);
                int newLocalMin = nums[i] * localMin;
                localMax = newLocalMax;
                localMin = newLocalMin;
            }else{
                int newLocalMax = Math.max(nums[i] * localMin, nums[i]);
                int newLocalMin = Math.min(nums[i] * localMax, nums[i]);
                localMax = newLocalMax;
                localMin = newLocalMin;
            }



            System.out.println(i+":"+localMin+","+localMax);
            maxProduct = Math.max(localMax, maxProduct);
        }

        return maxProduct;
    }
}