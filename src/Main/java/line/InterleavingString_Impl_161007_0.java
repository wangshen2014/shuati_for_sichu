package line;

/**
 * Created by patrickyu on 10/7/16.
 * 这样直接傻傻的移动双指针没办法 cover 顺序的问题
 */
public class InterleavingString_Impl_161007_0 implements InterleavingString {
    @Override
    public boolean isInterleave(String s1, String s2, String s3) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < s3.length(); i++) {
            char ai = s3.charAt(i);

            if (i1 < s1.length() && ai == s1.charAt(i1)) {
                i1++;
                System.out.println("i1." + i1);

            } else if (i2 < s2.length() && ai == s2.charAt(i2)) {
                i2++;
                System.out.println("i2." + i2);

            }

        }

        return i1 == s1.length() && i2 == s2.length();
    }
}
