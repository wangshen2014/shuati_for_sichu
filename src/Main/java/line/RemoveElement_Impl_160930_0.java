package line;

/**
 * Created by patrickyu on 9/29/16.
 */
public class RemoveElement_Impl_160930_0 implements RemoveElement {

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            throw new IllegalArgumentException("invalid input argument");
        }
        int end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[++end] = nums[i];
            }
        }
        return end + 1;
    }
}
