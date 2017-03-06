package line;

import java.util.*;

/**
 * Created by patrickyu on 10/4/16.
 */
public class SubstringWithConcatenationOfAllWords_Impl_161004_2 implements SubstringWithConcatenationOfAllWords {

    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rst = new ArrayList<>();


        String pattern = "";
        StringBuilder sb = new StringBuilder();

        Arrays.sort(words);
        for (String str : words) {
            sb.append(str);
        }
        pattern += sb.toString();


        int wordLen = words[0].length();

        int i = wordLen * words.length - 1;
        int start = 0;

        for (; i < s.length(); i++) {

            List<String> list = new ArrayList<>();
            for (int j = start + wordLen; j <= i + 1; j += wordLen) {
                String str = s.substring(j - wordLen, j);
                list.add(str);
            }

            Collections.sort(list);
            StringBuilder sb2 = new StringBuilder();
            for (int k = 0; k < list.size(); k++) {
                sb2.append(list.get(k));
            }


            if (pattern.equals(sb2.toString())){
                rst.add(start);
            }

            start++;
        }


        return rst;
    }
}
