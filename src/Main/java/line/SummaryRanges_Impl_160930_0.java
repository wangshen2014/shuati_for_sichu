package line;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrickyu on 9/30/16.
 */
public class SummaryRanges_Impl_160930_0 implements SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        // aux variables
        List<String> rst = new ArrayList<String>();
        int start = 0;

        // MI
        for (int i = 1; i <= nums.length; i++) {
            // [4] || [3]
            // if( (i!= nums.length && nums[i] != nums[i-1]+1) || i == nums.length ){

            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                // merget[start -> i-1]
                String s = new String();
                if (nums[start] != nums[i - 1]) {
                    s = nums[start] + "->" + nums[i - 1];
                } else {
                    s = nums[start] + "";
                }

                // start
                start = i;

                // rst
                rst.add(s);
            }
        }

        return rst;
    }
}
