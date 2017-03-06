package line;

import java.util.LinkedList;

/**
 * Created by patrickyu on 10/3/16.
 */
public class PlusOne_Impl_161003_0 implements PlusOne {
    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();

        int carryIn = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carryIn;
            carryIn = sum / 10;
            list.addFirst(sum % 10);
        }

        if (carryIn != 0) {
            list.addFirst(carryIn);
        }

        int i = 0;
        int[] rst = new int[list.size()];
        for (Integer num : list) {
            rst[i++] = num;
        }

        return rst;
    }
}
