// Problem link: https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
// Status: Accepted

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int nums1Len = nums1.length;
        for(int i = 0; i < nums1Len; i++) {
             hm.put(nums1[i], hm.getOrDefault(nums1[i], 0) + 1);
        }
        int nums2Len = nums2.length;
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(int i = 0; i < nums2Len; i++) {
            if(hm.containsKey(nums2[i])) {
                hm.put(nums2[i], hm.get(nums2[i]) - 1);
                l.add(nums2[i]);
                if(hm.get(nums2[i]) == 0) hm.remove(nums2[i]);
            }
        }
        int lLen = l.size();
        int [] answers = new int[lLen];
        for(int i = 0; i < lLen; i++) answers[i] = l.get(i);
        return answers;
    }
}
