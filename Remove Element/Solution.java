// Problem link: https://leetcode.com/problems/remove-element/description/
// Status: Accepted

class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = -1;
        for(int fast = 0; fast < nums.length; fast++) {
            if(nums[fast] == val) continue;
            if(fast - 1 != slow) nums[slow + 1] = nums[fast];
            slow++;
        }
        return slow + 1;
    }
}
