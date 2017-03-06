package line;

import org.junit.Test;

/**
 * Created by patrickyu on 10/7/16.
 * 没有做出来了
 */
public class PaintHouseII_Impl_161007_0 implements PaintHouseII {
    @Override
    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        int preColor = -1;

        for (int i = 0; i < costs[0].length; i++) {
            if (costs[0][i] < minCost) {
                minCost = costs[0][i];
                preColor = i;
            }
        }

        for (int i = 1; i < costs.length; i++) {
            int currMinCost1 = Integer.MAX_VALUE;
            int currMinCost1_color = -1;

            int currMinCost2 = Integer.MAX_VALUE;
            int currMinCost2_color = -1;

            for (int j = 0; j < costs[i].length; j++) {
                if (costs[i][j] < currMinCost2) {
                    currMinCost2 = costs[i][j];
                    currMinCost2_color = j;
                }

                if (costs[i][j] < currMinCost1) {
                    currMinCost2 = currMinCost1;
                    currMinCost2_color = currMinCost1_color;

                    currMinCost1 = costs[i][j];
                    currMinCost1_color = j;
                }
            }

            System.out.println(currMinCost1);
            System.out.println(currMinCost2);

            if (currMinCost1_color != preColor) {
                minCost += currMinCost1;
                preColor = currMinCost1_color;
            } else {
                minCost += currMinCost2;
                preColor = currMinCost2_color;
            }
        }
        return minCost;
    }

    @Test
    public void test() {
        System.out.println(minCostII(new int[][]{new int[]{1, 5, 3}, new int[]{2, 9, 4}}));
    }
}
