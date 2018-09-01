// Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// Status: Accepted

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 1;
        while(fast < nums.length) {
            while(fast < nums.length && nums[fast - 1] == nums[fast]) fast++;
            if(fast < nums.length) nums[++slow] = nums[fast++];
        }
        return slow + 1;
    }
}
