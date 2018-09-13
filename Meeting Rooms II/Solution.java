// Problem link: https://leetcode.com/problems/meeting-rooms-ii/description/
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
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        int max = Integer.MIN_VALUE;
        for(Interval i : intervals) {
            if(!pq.isEmpty() && pq.peek().end <= i.start) pq.poll();
            pq.offer(i);
            max = Math.max(max, pq.size());
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
