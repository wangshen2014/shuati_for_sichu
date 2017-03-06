package sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by patrickyu on 10/13/16.
 */

public class InsertInterval_Impl_161013_0 implements InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> rst = new ArrayList<>();
        Iterator<Interval> iter = intervals.iterator();

        Interval tmp = new Interval(newInterval.start, newInterval.end);


        while (iter.hasNext()) {
            Interval cur = iter.next();
            if (isOverLapping(cur, tmp)) {
                tmp.start = Math.min(cur.start, tmp.start);
                tmp.end = Math.max(cur.end, tmp.end);
                iter.remove();
            }
        }


        for (int i = 0; i <= intervals.size(); i++) {
            if (i == intervals.size()) {
                intervals.add(tmp);
                break;
            } else if (tmp.end < intervals.get(i).start) {
                intervals.add(i, tmp);
                break;
            }
        }

        return intervals;
    }

    private boolean isOverLapping(Interval i1, Interval i2) {


        return i2.start <= i1.end && i2.end >= i1.start;
    }

    @Test
    public void test() {
        // test1
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        Interval newInterval = new Interval(2, 5);

        System.out.println(insert(intervals, newInterval));

        // test2
        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));

        newInterval = new Interval(4, 9);

        System.out.println(insert(intervals, newInterval));

        // test3
        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));

        newInterval = new Interval(2, 7);

        System.out.println(insert(intervals, newInterval));

        // test4
        intervals = new ArrayList<>();

        newInterval = new Interval(5, 7);

        System.out.println(insert(intervals, newInterval));

        // test5
        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));

        newInterval = new Interval(2, 3);

        System.out.println(insert(intervals, newInterval));

        // test6
        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));

        newInterval = new Interval(6, 8);

        System.out.println(insert(intervals, newInterval));


    }

}
