package line;

/**
 * Created by patrickyu on 10/3/16.
 */
public class MinimumWindowSubstring_Impl_161003_0 implements MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        String rst = "";
        int[] tMap = new int[256];
        for(int i=0; i<t.length(); i++){
            tMap[t.charAt(i)]++;
        }


        int[] map = new int[256];
        int total = 0;
        int start = 0;

        for(int i=0; i<s.length();i++){
            char ai = s.charAt(i);

            if(tMap[ai] > 0){
                if(tMap[ai] > map[ai]){
                    map[ai]++;
                    total++;
                }else{
                    map[ai]++;
                }
            }


            if(total == t.length()){
                while( tMap[s.charAt(start)] == 0 || map[s.charAt(start)] > tMap[s.charAt(start)]){
                    map[s.charAt(start)]--; // 这里直接忽略掉了 A[i] 不属于 tMap 的情况,直接照着减
                    start++;
                }

                if(rst.equals("") || i-start+1 < rst.length()){
                    rst = s.substring(start, i+1);
                }
            }
        }

        return rst;
    }
}
