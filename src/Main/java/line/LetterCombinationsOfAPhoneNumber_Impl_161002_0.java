package line;

import java.util.*;

/**
 * Created by patrickyu on 10/2/16.
 */
public class LetterCombinationsOfAPhoneNumber_Impl_161002_0 implements LetterCombinationsOfAPhoneNumber {

    @Override
    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = new HashMap<>();
        map.put('0', Arrays.asList(" "));
        map.put('1', Arrays.asList());
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));



        List<String> rst = new LinkedList<>(Arrays.asList(""));

        if (digits.length() == 0){
            rst.remove(0);
            return rst;
        }
        for (int i = 0; i < digits.length(); i++) {
            int size = rst.size();
            for (int j = 0; j < size; j++) {
                String str = rst.remove(0);
                for (int k = 0; k < map.get(digits.charAt(i)).size(); k++) {
                    rst.add(str + map.get(digits.charAt(i)).get(k));
                }
            }
        }

        System.out.println(rst);
        return rst;
    }
}
