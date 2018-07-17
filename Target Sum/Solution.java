// Problem link: https://leetcode.com/problems/target-sum/description/
// Status: Accepted

class Solution {
    private int dp(int [] nums, int sum, int index, int target) {
        if(index > nums.length) return 0;
        if(index == nums.length) return sum == target ? 1 : 0;
        return dp(nums, sum + nums[index], index + 1, target) + dp(nums, sum - nums[index], index + 1, target);
    }
    public int findTargetSumWays(int [] nums, int S) {
        return dp(nums, 0, 0, S);
    }
}
