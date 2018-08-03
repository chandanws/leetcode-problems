// Problem link: https://leetcode.com/problems/house-robber/description/
// Status: Accepted

class Solution {
    public int rob(int[] nums) {
        int prevMax = 0, currentMax = 0;
        for(int num : nums) {
            int temp = currentMax;
            currentMax = Math.max(prevMax + num, currentMax);
            prevMax = temp;
        }
        return currentMax;
    }
}
