// Problem link: https://leetcode.com/problems/merge-sorted-array/description/
// Status: Accepted

class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if(n == 0) { return; }
    for(int i = m; i < m + n; i++) {
      nums1[i] = nums2[i - m];
    }
    for(int j = 0; j <= m; j++) {
      if(nums1[j] > nums1[m]) {
        int temp = nums1[j];
        nums1[j] = nums1[m];
        nums1[m] = temp;
        int k = m;
        while(k < m + n - 1 && nums1[k] > nums1[k+1]) {
          temp = nums1[k];
          nums1[k] = nums1[k + 1];
          nums1[k + 1] = temp;
          k++;
        }
      }
    }
  }
}
