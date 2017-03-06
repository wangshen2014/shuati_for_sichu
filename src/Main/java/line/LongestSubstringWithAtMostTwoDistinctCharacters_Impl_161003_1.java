package line;

/**
 * Created by patrickyu on 10/3/16.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters_Impl_161003_1 implements LongestSubstringWithAtMostTwoDistinctCharacters {
    @Override
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }
        if (s.length() == 2) {
            return 2;
        }

        int[] map = new int[256];
        int size = 0;
        int start = 0;
        int rst = 0;

        // 0 : n-1
        for (int i = 0; i < s.length(); i++) {
            char ai = s.charAt(i);


            if (size < 2) {
                if (map[ai] == 0) {
                    map[ai]++;
                    size++;
                } else {
                    map[ai]++;
                }
            } else if (size == 2) {
                if (map[ai] == 0) {
                    while (size == 2) {
                        map[s.charAt(start)] -= 1;
                        if (map[s.charAt(start)] == 0) {
                            size--;
                        }
                        start++;
                    }
                    map[ai] ++;
                    size ++;
                }else{
                    map[ai]++;
                }
            }
            rst = i - start + 1 > rst ? i - start + 1 : rst;

        }
        return rst;
    }
}
