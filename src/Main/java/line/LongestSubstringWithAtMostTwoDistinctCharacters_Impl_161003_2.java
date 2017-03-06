package line;

/**
 * Created by patrickyu on 10/3/16.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters_Impl_161003_2 implements LongestSubstringWithAtMostTwoDistinctCharacters {
    @Override
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int K = 2;

        if (s.length() <= K) {
            return s.length();
        }

        int[] map = new int[256];
        int size = 0;
        int start = 0;
        int rst = 0;

        // 0 : n-1
        for (int i = 0; i < s.length(); i++) {
            char ai = s.charAt(i);


            if (size < K) {
                map[ai]++;
                if (map[ai] == 1) {
                    size++;
                }
            } else if (size == K) {
                if (map[ai] == 0) {
                    while (size == K) {
                        map[s.charAt(start)] -= 1;
                        if (map[s.charAt(start)] == 0) {
                            size--;
                        }
                        start++;
                    }
                    map[ai] = 1;
                    size++;
                } else {
                    map[ai]++;
                }
            }
            rst = i - start + 1 > rst ? i - start + 1 : rst;
        }
        return rst;
    }
}
