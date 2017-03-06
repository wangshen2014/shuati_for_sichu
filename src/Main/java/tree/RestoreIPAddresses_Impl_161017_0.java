package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by patrickyu on 10/17/16.
 */
public class RestoreIPAddresses_Impl_161017_0 implements RestoreIPAddresses {
    @Override
    public List<String> restoreIpAddresses(String s) {
        return helper(99, -1, 4, 12, s);
    }

    private List<String> helper(int start, int end, int min, int max, String s) {
        if (min == 0) {
            return new ArrayList<>(Arrays.asList(s.substring(start, end + 1)));
        }


        List<String> rst = new ArrayList<>();
        int startChild = end + 1;

        for (int i = 0; i < 3; i++) {
            int endChild = startChild + i;
            int remainChild = s.length() - endChild - 1;
            int minChild = min - 1;
            int maxChild = max - 3;
            if (minChild <= remainChild && remainChild <= maxChild && Integer.valueOf(s.substring(startChild, endChild + 1)) <= 255 && (startChild == endChild || s.charAt(startChild) != '0')) {

                // rst from op(a[i+1])
                List<String> childRst = helper(startChild, endChild, minChild, maxChild, s);

                if (min != 4) {
                    for (String r : childRst) {
                        rst.add(s.substring(start, end + 1) + "." + r); // rst at op(a[i])
                    }
                } else {
                    rst.addAll(childRst);
                }
            }
        }

        return rst;
    }
}
