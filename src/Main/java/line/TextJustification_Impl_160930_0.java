package line;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patrickyu on 9/30/16.
 * 这个版本的 是没有去整理真正的空格的那种算法, 真正解这道题的算法,实际上就多了一层除法来整理空格就好了, 第二版本就有写
 */
public class TextJustification_Impl_160930_0 implements TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        // aux variable
        List<String> rst = new ArrayList<String>();
        int start = 0;
        int count = words[0].length();

        // 1:n
        for (int i = 1; i <= words.length; i++) {

            if (i != words.length){
                count += words[i].length() + 1;
            }

            // [4]
            if (i == words.length) {
                StringBuilder sb = new StringBuilder();
                for (int j = start; j <= i - 1; j++) {
                    sb.append(words[j] + " ");
                }
                rst.add(sb.toString().substring(0, sb.length() - 1));
            }

            // [3]
            if (count > maxWidth) {
                StringBuilder sb = new StringBuilder();
                for (int j = start; j <= i - 1; j++) {
                    sb.append(words[j] + " ");
                }
                rst.add(sb.toString().substring(0, sb.length() - 1));

                count = words[i].length();
                start = i;
            }

        }
        return rst;
    }


}
