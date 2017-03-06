package line;

/**
 * Created by patrickyu on 10/6/16.
 */
public class TrappingRainWater_Impl_161006_0 implements TrappingRainWater {
    @Override
    public int trap(int[] height) {
        int sumWater = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            left[i] = i;
            if (i - 1 >= 0 && height[left[i - 1]] >= height[i]) {
                left[i] = left[i - 1];
            }
        }

        for (int i = height.length - 1; i >= 0; i--) {
            right[i] = i;
            if (i + 1 < height.length && height[right[i + 1]] >= height[i]) {
                right[i] = right[i + 1];
            }
        }

        for (int i = 1; i < height.length - 1; i++) {
            int ceiling = Math.min(height[left[i]], height[right[i]]);
            sumWater += ceiling - height[i];
        }

        return sumWater;
    }
}
