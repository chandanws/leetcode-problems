// Problem link: https://leetcode.com/problems/merge-intervals/description/
// Status: Accepted

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start != i2.start) return i1.start - i2.start;
                return i1.end - i2.end;
            }
        });
        List<Interval> res = new ArrayList<>();
        if(intervals.size() == 0) return res;
        int i = 1;
        Interval currentInterval = new Interval(intervals.get(0).start, intervals.get(0).end);
        while(i < intervals.size()) {
            int start = currentInterval.start, end = currentInterval.end;
            if(start <= intervals.get(i).start && intervals.get(i).start <= end) {
                currentInterval.start = Math.min(currentInterval.start, intervals.get(i).start);
                currentInterval.end = Math.max(currentInterval.end, intervals.get(i).end);
            } else {
                res.add(currentInterval);
                currentInterval = new Interval(intervals.get(i).start, intervals.get(i).end);
            }
            i++;
        }
        res.add(currentInterval);
        return res;
    }
}
