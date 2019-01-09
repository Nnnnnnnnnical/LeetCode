package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 */
public class leetcode435 {

    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public static int eraseOverlapIntervals(Interval[] intervals){
        if(intervals.length == 0){
            return  0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end - o2.end;
            }
        });

        int count = 1;
        int end = intervals[0].end;
        for(int i = 1;i<intervals.length;i++){
            if(end>intervals[i].start){
                continue;
            }

            count++;
            end = intervals[i].end;
        }
        return intervals.length-count;
    }

    public static void main(String[] args){
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(1,2);
        intervals[1] = new Interval(1,2);
        intervals[2] = new Interval(1,2);
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
