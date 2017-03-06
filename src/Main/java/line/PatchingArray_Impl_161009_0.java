package line;

import org.junit.Test;

/**
 * Created by patrickyu on 10/9/16.
 */
public class PatchingArray_Impl_161009_0 implements PatchingArray {
    @Override
    public int minPatches(int[] nums, int n) {

        int count = 0;
        int range = 0;
        for (int i = 0; i < nums.length; i++) {
            while (range < nums[i] - 1) {
                if (range >= n) {
                    return count;
                }
                count++;
                range = range * 2 + 1;
            }
            range += nums[i];
        }

        while (range < n) {
            count++;
            range = range * 2 + 1;
        }
        return count;
    }

    @Test
    public void test() {

    }
}
