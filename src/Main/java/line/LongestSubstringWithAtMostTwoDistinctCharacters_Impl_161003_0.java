package line;

/**
 * Created by patrickyu on 10/3/16.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters_Impl_161003_0 implements LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[256];
        int size = 0;
        int start = 0;
        int rst = 0;

        // 0 : n-1
        for (int i = 0; i < s.length(); i++) {
            char ai = s.charAt(i);

            if (size < 2) {
                map[ai]++;
                size++;
            } else if (size == 2) {
                if (map[ai] == 0) {
                    while (size == 2 && start < s.length()) {
                        map[s.charAt(start)] -= 1;
                        if (map[s.charAt(start)] == 0) {
                            size--;
                        }
                        start++;
                    }
                }
                rst = i - start + 1 > rst ? i - start + 1 : rst;
            }
        }
        return rst;
    }
}
