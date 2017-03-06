package line;

/**
 * Created by patrickyu on 10/6/16.
 */
public class LargestRectangleInHistogram_Impl_161006_0 implements LargestRectangleInHistogram {
    @Override
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            left[i] = i;

            while (left[i] > 0 && heights[left[i] - 1] >= heights[i]) {
                left[i] = left[left[i] - 1];
            }
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            right[i] = i;
            while (right[i] < heights.length - 1 && heights[right[i] + 1] >= heights[i]) {
                right[i] = right[right[i] + 1];
            }
        }

        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * heights[i]);
        }
        return maxArea;
    }
}
