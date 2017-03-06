package line;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrickyu on 10/2/16.
 */
public class Subsets_Impl_121002_0 implements Subsets {

    @Override
    public List<List<Integer>> subsets(int[] nums) {
        // i = -1;
        List<List<Integer>> rst = new ArrayList<>();

        rst.add(new ArrayList<>());

        // i = 0:n-1
        for(int i=0; i<nums.length;i++){
            int size = rst.size();
            for(int j=0; j<size; j++){
                List<Integer> list = new ArrayList(rst.get(j));
                list.add(nums[i]);
                rst.add(list);
            }
        }

        System.out.println(rst);
        return rst;
    }
}
