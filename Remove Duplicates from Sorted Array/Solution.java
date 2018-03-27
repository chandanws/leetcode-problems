// Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// Status: Accepted

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while(fast < nums.length) {
            if(nums[fast] == nums[slow]) {
                fast++;
            } else {
                if(fast - 1 != slow) nums[slow + 1] = nums[fast];
                fast++;
                slow++;
            }
        }
        return slow + 1;
    }
}
