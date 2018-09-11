// Problem link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
// Status: Accepted

class Solution {
    public List<int []> kSmallestPairs(int [] nums1, int [] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        List<int []> res = new ArrayList<>();
        if(n == 0 || m == 0) return res;
        PriorityQueue<int []> pq = new PriorityQueue<int []>(new Comparator<int []>() {
            @Override
            public int compare(int [] a, int [] b) {
                return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
            }
        });
        if(n < m) {
            for(int i = 0; i < n; i++) pq.offer(new int[]{i, 0});
        } else {
            for(int i = 0; i < m; i++) pq.offer(new int[]{0, i});
        }
        for(int i = 0; i < k && !pq.isEmpty(); i++) {
            int [] next = pq.poll();
            res.add(new int[]{nums1[next[0]], nums2[next[1]]});
            if(n < m) {
                if(next[1] + 1 < m) {
                    next[1]++;
                    pq.offer(next);
                }
            } else {
                if(next[0] + 1 < n) {
                    next[0]++;
                    pq.offer(next);
                }
            }
        }
        return res;
    }
}
