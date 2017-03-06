package line;

/**
 * Created by patrickyu on 10/3/16.
 */
public class RemoveDuplicatesFromSortedArray_Impl_161003_0 implements RemoveDuplicatesFromSortedArray {
    @Override
    public int removeDuplicates(int[] nums) {
        int end = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != nums[end]){
                nums[++end] = nums[i];
            }
        }
        return end + 1;
    }
}
