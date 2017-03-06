package line;

import java.util.Arrays;

/**
 * Created by patrickyu on 10/3/16.
 */
public class LongestSubstringWithoutRepeatingCharacters_Impl_161003_0 implements LongestSubstringWithoutRepeatingCharacters {
    @Override
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int NOT_FOUND = -1;
        Arrays.fill(map, NOT_FOUND);

        int start = 0;
        int rst = 0;

        // i = 0:n-1
        for (int i = 0; i < s.length(); i++) {
            char ai = s.charAt(i);

            // 1. find conditions
            if (map[ai] == NOT_FOUND) {
                map[ai] = i;
            } else {
                int newStart = map[ai] + 1;
                for (int j = start; j <= map[ai]; j++) {
                    map[s.charAt(j)] = NOT_FOUND;
                }
                start = newStart;
                map[ai] = i;
            }

            // 2. calculate result
            rst = Math.max(rst, i - start + 1);
        }

        return rst;
    }
}
