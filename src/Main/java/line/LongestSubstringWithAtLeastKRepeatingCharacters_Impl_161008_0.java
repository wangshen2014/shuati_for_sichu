package line;

/**
 * Created by patrickyu on 10/8/16.
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters_Impl_161008_0 implements LongestSubstringWithAtLeastKRepeatingCharacters {
    @Override
    public int longestSubstring(String s, int k) {

        int rst = 0;
        int[] map = new int[256];

        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ai = s.charAt(i);

            map[ai]++;

            if (map[ai] == k) {
                rst = Math.max(rst, i - start + 1);
            }else if (map[ai] > k){
                while (map[ai] > k){

                }
            }
        }


        return rst;
    }
}
