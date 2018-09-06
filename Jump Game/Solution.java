// Problem link: https://leetcode.com/problems/jump-game/description/
// Status: Accepted

class Solution {
    public boolean canJump(int [] nums) {
        int n = nums.length, last = n - 1;
        for(int i = n - 1; i >= 0; i--) {
            if(i + nums[i] >= last) last = i;
        }
        return last == 0;
    }
}
