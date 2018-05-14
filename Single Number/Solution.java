// Problem link: https://leetcode.com/problems/single-number/description/
// Status: Accepted

class Solution {
    public int singleNumber(int[] nums) {
        int result = nums[0], len = nums.length;
        for(int i = 1; i < len; i++) result ^= nums[i];
        return result;
    }
}
