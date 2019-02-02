// Problem link: https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/

// Status: Accepted

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int start = 0, end = 0, max = nums.length > 0 ? 1 : 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[end]) end++;
            else {
                start = i;
                end = i;
            }
            if(end - start + 1 > max) max = end - start + 1;
        }
        return max;
    }
}
