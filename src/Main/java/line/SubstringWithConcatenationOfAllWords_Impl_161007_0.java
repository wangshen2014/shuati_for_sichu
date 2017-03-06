package line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by patrickyu on 10/7/16.
 */
public class SubstringWithConcatenationOfAllWords_Impl_161007_0 implements SubstringWithConcatenationOfAllWords {
    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rst = new ArrayList<>();
        Map<String, Integer> mapWords = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (mapWords.containsKey(words[i])) {
                mapWords.put(words[i], mapWords.get(words[i]) + 1);
            } else {
                mapWords.put(words[i], 1);
            }
        }
        System.out.println(mapWords);

        int smallWidth = words[0].length();
        int bigWidth = smallWidth * words.length;

        for (int i = 0; i <= s.length() - bigWidth; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int total = 0;

            for (int j = i; j < i + bigWidth; j += smallWidth) {
                String word = s.substring(j, j + smallWidth);
//                System.out.println(i + ":" + word);

                if (mapWords.containsKey(word)) {
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                    if (map.get(word) <= mapWords.get(word)){
                        total++;
                    }
                } else {
                    break;
                }
            }
            if (total == words.length) {
                rst.add(i);
            }
        }


        return rst;
    }
}
