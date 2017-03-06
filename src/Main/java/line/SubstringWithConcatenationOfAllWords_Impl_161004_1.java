package line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by patrickyu on 10/4/16.
 *
 * 这个算法又过了自己的 test case, 但是还是过不鸟 Leetcode 时间的要求
 *
 * 我觉得还是因为你生成了 map 原因,这个地方是非常耗时的, 因为这里不需要完全的 pattern 之间要 match, 实际上我们找到一个排序好了 words,
 * 每次走一个位置都跟这个比较就好了
 */
public class SubstringWithConcatenationOfAllWords_Impl_161004_1 implements SubstringWithConcatenationOfAllWords {
    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rst = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (String str : words) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        int wordLen = words[0].length();

        int i = wordLen * words.length - 1;
        int start = 0;

        for (; i < s.length(); i++) {

            Map<String, Integer> curMap = new HashMap<>();

            for (int j = start + wordLen; j <= i + 1; j += wordLen) {
                String str = s.substring(j - wordLen, j);


                if (!map.containsKey(str)) {
                    break;
                }
                if (curMap.containsKey(str)) {
                    curMap.put(str, curMap.get(str) + 1);
                } else {
                    curMap.put(str, 1);
                }
            }

            if (curMap.equals(map)) {
                rst.add(start);
            }

            start++;
        }


        return rst;
    }
}
