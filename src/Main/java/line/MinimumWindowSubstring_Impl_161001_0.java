package line;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by patrickyu on 10/1/16.
 * 这个算法只能过 test1, 但是过不了 test2
 */
public class MinimumWindowSubstring_Impl_161001_0 implements MinimumWindowSubstring {

    @Override
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (tMap.containsKey(t.charAt(i))) {
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            }else{
                tMap.put(t.charAt(i), 1);
            }
        }

        String rst = "";
        TreeMap<Integer, Character> treeMap = new TreeMap<>();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        String tmpRst = null;


        for (int i = 0; i <= s.length(); i++) {

            if (i < s.length()) {
                if (t.contains("" + s.charAt(i))) {
                    if (hashMap.size() != t.length()) {
                        hashMap.put(s.charAt(i), i);
                        treeMap.put(i, s.charAt(i));
                    } else {
                        tmpRst = s.substring(treeMap.firstKey(), treeMap.lastKey() + 1);
                        int index = hashMap.get(s.charAt(i));
                        hashMap.put(s.charAt(i), i);
                        treeMap.remove(index);
                        treeMap.put(i, s.charAt(i));
                    }
                }
            } else if (hashMap.size() == t.length()) {
                tmpRst = s.substring(treeMap.firstKey(), treeMap.lastKey() + 1);
            }


            if (tmpRst != null) {
                if (rst.length() == 0 || tmpRst.length() < rst.length()) {
                    rst = tmpRst;
                }
            }
        }
        return rst;
    }
}
