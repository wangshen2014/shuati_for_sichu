package line;

/**
 * Created by patrickyu on 10/3/16.
 */
public class MoveZeroes_Impl_161003_0 implements MoveZeroes {
    @Override
    public void moveZeroes(int[] nums) {
        int end = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[++end] = nums[i];
            }
        }

        int i = end+1;
        while(i < nums.length){
            nums[i++] = 0;
        }
    }
}
