package line;

/**
 * Created by patrickyu on 10/3/16.
 */
public class IsomorphicStrings_Impl_161003_0 implements IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        return helper(s, t) && helper(t, s);
    }


    public boolean helper(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] map = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char cS = s.charAt(i);
            char cT = t.charAt(i);
            if (map[cS] != 0 && map[cS] != cT) {
                return false;
            } else {
                map[cS] = cT;
            }
        }
        return true;
    }
}
