package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by patrickyu on 10/13/16.
 */
public class ShortestWordDistance_Impl_161013_0 implements ShortestWordDistance {
    @Override
    public int shortestDistance(String[] words, String word1, String word2) {

        Map<String, List<Integer>> map = new HashMap<>();


        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }

        int minDis = Integer.MAX_VALUE;

        int i1 = 0;
        int i2 = 0;

        while (i1 < map.get(word1).size() && i2 < map.get(word2).size()) {

            int iw1 = map.get(word1).get(i1);
            int iw2 = map.get(word2).get(i2);

            if (iw1 < iw2) {
                minDis = Math.min(minDis, iw2 - iw1);
                i1++;
            } else {
                minDis = Math.min(minDis, iw1 - iw2);
                i2++;
            }
        }

        return minDis;
    }


}
