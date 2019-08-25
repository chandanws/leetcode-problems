// Problem link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
// Status: Accepted

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int count = 1, index = 1;
        boolean seen = false;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] < nums[i]) {
                seen = false;
                count++;
                nums[index++] = nums[i];
            } else if(nums[i - 1] == nums[i] && !seen) {
                seen = true;
                count++;
                nums[index++] = nums[i];
            }
        }
        return count;
    }
}
