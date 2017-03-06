package line;

/**
 * Created by patrickyu on 10/3/16.
 */
public class RemoveDuplicatesFromSortedArrayII_Impl_161003_0 implements RemoveDuplicatesFromSortedArrayII {
    @Override
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        if (nums.length == 2) {
            return 2;
        }

        int end = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[end] || (nums[i] == nums[end] && nums[end - 1] != nums[end])) {
                nums[++end] = nums[i];
            }
        }
        return end + 1;
    }
}
