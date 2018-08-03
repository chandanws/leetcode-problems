// Problem link: https://leetcode.com/problems/house-robber-ii/description/
// Status: Accepted

class Solution {
    public int rob(int[] nums, int low, int high) {
        int prevMax = 0, currentMax = 0;
        for(int i = low; i <= high; i++) {
            int temp = currentMax;
            currentMax = Math.max(prevMax + nums[i], currentMax);
            prevMax = temp;
        }
        return currentMax;
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
}
