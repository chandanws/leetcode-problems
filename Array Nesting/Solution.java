// Problem link: https://leetcode.com/problems/array-nesting/description/
// Status: Accepted

class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        boolean seenZero = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > -1) {
                int currentMax = 0, j = i;
                while(nums[j] > -1) {
                    if(nums[j] > 0) nums[j] = nums[j] * -1;
                    else if(seenZero && nums[j] == 0) break;
                    else seenZero = true;
                    j = Math.abs(nums[j]);
                    currentMax++;
                }
                max = Math.max(max, currentMax);
            }
        }
        return max;
    }
}
