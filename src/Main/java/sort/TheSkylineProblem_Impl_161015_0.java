package sort;

import java.util.*;

/**
 * Created by patrickyu on 10/15/16.
 */
public class TheSkylineProblem_Impl_161015_0 implements TheSkylineProblem {
    @Override
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> rst = new ArrayList<>();

        if (buildings.length == 0 || buildings[0].length == 0) {
            return rst;
        }

        List<int[]> list = new ArrayList<>();

        for (int[] bld : buildings) {
            list.add(new int[]{bld[0], 0, bld[2]});
            list.add(new int[]{bld[1], 1, bld[2]});
        }

        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);


        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        heap.add(0);

        for (int[] itv : list) {

            if (itv[1] == 0) { // start
                heap.add(itv[2]);
            } else { // end
                heap.remove(itv[2]);
            }


            if (rst.size() == 0 || rst.get(rst.size() - 1)[1] != heap.peek()) {
                if (rst.size() > 0 && rst.get(rst.size() - 1)[0] == itv[0] && rst.get(rst.size() - 1)[1] == itv[1]) {
                    rst.remove(rst.size() - 1);
                } else if (rst.size() > 0 && rst.get(rst.size() - 1)[0] == itv[0]) {
                    rst.remove(rst.size() - 1);
                    rst.add(new int[]{itv[0], heap.peek()});
                } else {
                    rst.add(new int[]{itv[0], heap.peek()});
                }
            }

        }

        for (int[] itv : rst) {
            System.out.printf(Arrays.toString(itv) + ",");
        }
        System.out.println();
        return rst;
    }
}
