package sort;

import java.util.List;

/**
 * Created by patrickyu on 10/13/16.
 */

public interface InsertInterval {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + "," + end + ']';
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval);

}
