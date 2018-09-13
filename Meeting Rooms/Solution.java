// Problem link: https://leetcode.com/problems/meeting-rooms/description/
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
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval n1, Interval n2) {
                return n1.start - n2.start;
            }
        });
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start >= intervals[i - 1].start && intervals[i].start < intervals[i - 1].end) return false;
        }
        return true;
    }
}
