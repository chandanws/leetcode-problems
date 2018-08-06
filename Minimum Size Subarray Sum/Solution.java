// Problem link: https://leetcode.com/problems/minimum-size-subarray-sum/description/
// Status: Accepted

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, currentSum = nums.length > 0 ? nums[0] : 0, min = Integer.MAX_VALUE;
        while(right < nums.length) {
            if(currentSum >= s) min = Math.min(min, right - left + 1);
            if(currentSum <= s || left == right) {
                if(++right >= nums.length) break;
                currentSum += nums[right];
            } else currentSum -= nums[left++];
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
