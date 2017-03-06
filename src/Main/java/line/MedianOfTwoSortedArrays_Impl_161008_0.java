package line;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by patrickyu on 10/8/16.
 */
public class MedianOfTwoSortedArrays_Impl_161008_0 implements MedianOfTwoSortedArrays {
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for (int i = 0; i < nums1.length; i++) {

            minHeap.offer(nums1[i]);
            maxHeap.offer(minHeap.poll());

            if (maxHeap.size() > minHeap.size()) {
                maxHeap.offer(maxHeap.poll());
            }
        }


        for (int i = 0; i < nums2.length; i++) {
            minHeap.offer(nums2[i]);
            maxHeap.offer(minHeap.poll());

            if (maxHeap.size() > minHeap.size()) {
                maxHeap.offer(maxHeap.poll());
            }
        }
        System.out.println("maxHeap: " + maxHeap);
        System.out.println("minHeap: " + minHeap);

        if (minHeap.size() == maxHeap.size()) {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
        } else {
            return minHeap.peek();
        }
    }

    @Test
    public void test() {


        int[] num1 = new int[]{2, 3};
        int[] num2 = new int[]{1};

        System.out.println("rst: " + findMedianSortedArrays(num1, num2));
    }
}
