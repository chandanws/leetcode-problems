// Problem link: https://leetcode.com/problems/missing-number/description/
// Status: Accepted

class Solution {
    public int missingNumber(int[] nums) {
        boolean hasZero = false, hasMax = false;
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) hasZero = true;
            if(nums[i] == nums.length) hasMax = true;
            sum += nums[i];
        }
        if(!hasZero) return 0;
        if(!hasMax) return nums.length;
        return (int)((((nums.length+1)*nums.length)/2)-sum);
    }
}
