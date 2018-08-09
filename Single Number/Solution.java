// Problem link: https://leetcode.com/problems/single-number/description/
// Status: Accepted

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) res ^= num;
        return res;
    }
}
