// Problem link: https://leetcode.com/problems/merge-sorted-array/description/
// Status: Accepted

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = m - 1, ptr2 = n - 1;
        for(int i = nums1.length - 1; i >= 0; i--) {
            if(ptr1 >= 0 && ptr2 >= 0) {
                if(nums1[ptr1] > nums2[ptr2]) nums1[i] = nums1[ptr1--];
                else nums1[i] = nums2[ptr2--];
            } else if(ptr1 >= 0) {
                nums1[i] = nums1[ptr1--];
            } else {
                nums1[i] = nums2[ptr2--];
            }
        }
    }
}
