package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by patrickyu on 10/4/16.
 */
public class PermutationsII_Impl_161004_0 implements PermutationsII {
    @Override
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> rst = new ArrayList<>();
        // i = -1
        rst.add(new ArrayList<>());


        // i = 0: n -1
        for (int i = 0; i < nums.length; i++) {

            int size = rst.size();
            for (int j = 0; j < size; j++) {
                List<Integer> list = rst.remove(0);
                for (int k = 0; k <= list.size(); k++) {
                    List<Integer> listK = new ArrayList<>(list);

                    if(k == list.size() || list.get(k) != nums[i]){
                        listK.add(k, nums[i]);
                        rst.add(listK);
                    }

                }
            }
        }

        return rst;
    }
}
