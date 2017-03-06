package line;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by patrickyu on 10/1/16.
 * 解决了 test[1->3]
 */
public class MinimumWindowSubstring_Impl_161001_1 implements MinimumWindowSubstring {

    @Override
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char cT = t.charAt(i);
            if (!tMap.containsKey(cT)) {
                tMap.put(cT, 1);
            } else {
                tMap.put(cT, tMap.get(cT) + 1);
            }
        }

        TreeMap<Integer, Character> treeMap = new TreeMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        String rst = "";
        String tmpRst = null;

        for (int i = 0; i <= s.length(); i++) {

            if (i != s.length()) {
                char ch = s.charAt(i);

                if (tMap.containsKey(ch)) {

                    if (tMap.equals(map)) {
                        tmpRst = s.substring(treeMap.firstKey(), treeMap.lastKey() + 1);

                        while (!treeMap.isEmpty()) {
                            Map.Entry<Integer, Character> entry = treeMap.pollFirstEntry();

                            int count = map.get(entry.getValue());
                            count -= 1;
                            if (count == 0) {
                                map.remove(entry.getValue());
                            } else {
                                map.put(entry.getValue(), count);
                            }
                            if (entry.getValue() == ch) {
                                break;
                            }
                        }

                        treeMap.put(i, ch);

                        if (map.containsKey(ch)) {
                            map.put(ch, map.get(ch) + 1);
                        } else {
                            map.put(ch, 1);
                        }

                    } else if (!map.containsKey(ch) || map.get(ch) < tMap.get(ch)) {
                        if (!map.containsKey(ch)){
                            map.put(ch, 1);
                        }else {
                            map.put(ch, map.get(ch) + 1);
                        }

                        treeMap.put(i, ch);
                    } else if (map.containsKey(ch) && map.get(ch).equals(tMap.get(ch))){

                        while (!treeMap.isEmpty()){
                            Map.Entry<Integer, Character> entry = treeMap.pollFirstEntry();

                            int count = map.get(entry.getValue());
                            count -= 1;
                            if (count == 0) {
                                map.remove(entry.getValue());
                            } else {
                                map.put(entry.getValue(), count);
                            }
                            if (entry.getValue() == ch) {
                                break;
                            }
                        }

                        treeMap.put(i, ch);

                        if (map.containsKey(ch)) {
                            map.put(ch, map.get(ch) + 1);
                        } else {
                            map.put(ch, 1);
                        }

                    }
                }
            } else if (i == s.length() && tMap.equals(map)) {
                tmpRst = s.substring(treeMap.firstKey(), treeMap.lastKey() + 1);
            }


            // generate result
            if (tmpRst != null) {
                System.out.println(tmpRst);
                if (rst.length() == 0 || rst.length() > tmpRst.length()) {
                    rst = tmpRst;
                }

            }
        }

        return rst;
    }
}
