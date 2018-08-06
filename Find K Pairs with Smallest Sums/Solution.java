// Problem link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
// Status: Accepted

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                res.add(new int[]{nums1[i], nums2[j]});
            }
        }
        Collections.sort(res, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] + a[1]) - (b[0] + b[1]);
            }
        });
        for(int i = res.size() - 1; i >= k; i--) res.remove(res.size() - 1);
        return res;
    }
}
