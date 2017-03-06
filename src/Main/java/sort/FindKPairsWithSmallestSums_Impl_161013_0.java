package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by patrickyu on 10/13/16.
 */
public class FindKPairsWithSmallestSums_Impl_161013_0 implements FindKPairsWithSmallestSums {
    @Override
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<int[]> rst = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0) {
            return rst;
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);


        for (int i = 0; i < nums1.length; i++) {
            heap.add(new int[]{i, 0, nums1[i] + nums2[0]});
        }


        for (int i = 0; i < k; i++) {
            int[] cur = heap.poll();
            if (cur == null){
                break;
            }
            rst.add(new int[]{nums1[cur[0]], nums2[cur[1]]});
            int nextIndex = cur[1] + 1;
            if (nextIndex < nums2.length) {
                heap.add(new int[]{cur[0], nextIndex, nums1[cur[0]] + nums2[nextIndex]});
            }
        }

        return rst;
    }


    @Test
    public void test() {
        int[] nums1 = new int[]{1, 7, 11};
        int[] nums2 = new int[]{2, 4, 6};
        int k = 3;
        System.out.println("---test1---");
        for (int[] ans : kSmallestPairs(nums1, nums2, k)) {
            System.out.printf(Arrays.toString(ans));
        }
        System.out.println();

        nums1 = new int[]{1, 1, 2};
        nums2 = new int[]{1, 2, 3};
        k = 2;
        System.out.println("---test2---");
        for (int[] ans : kSmallestPairs(nums1, nums2, k)) {
            System.out.printf(Arrays.toString(ans));
        }
        System.out.println();

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3};
        k = 3;
        System.out.println("---test3---");
        for (int[] ans : kSmallestPairs(nums1, nums2, k)) {
            System.out.printf(Arrays.toString(ans));
        }
        System.out.println();

    }
}
