// Problem link: https://leetcode.com/problems/intersection-of-two-arrays/description/
// Status: Accepted

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return new int[]{};
        HashSet<Integer> hs1 = new HashSet<>();
        for(int num : nums1) {
            hs1.add(num);
        }
        HashSet<Integer> hs2 = new HashSet<>();
        for(int num : nums2) {
            if(hs1.contains(num)) hs2.add(num);
        }
        int i = 0;
        int [] res = new int[hs2.size()];
        for (Integer num : hs2) {
            res[i++] = num;
        }
        return res;
    }
}
