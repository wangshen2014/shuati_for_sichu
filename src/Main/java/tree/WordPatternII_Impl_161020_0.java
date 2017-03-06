package tree;

import org.junit.Test;

/**
 * Created by patrickyu on 10/20/16.
 */
public class WordPatternII_Impl_161020_0 implements WordPatternII {
    @Override
    public boolean wordPatternMatch(String pattern, String str) {

        int[] map = new int[256];
        int mapSize = 0;
        for (int i = 0; i < pattern.length(); i++) {

            if (map[pattern.charAt(i)] == 0) {
                mapSize++;
            }
            map[pattern.charAt(i)]++;
        }


//        System.out.println(Arrays.toString(map));
        System.out.println(mapSize);
        return false;
    }

    @Test
    public void test() {
        String str = "redblueredblue";
        String pattern = "abab";

    }
}
