// Problem link: https://leetcode.com/problems/single-element-in-a-sorted-array/description/
// Status: Accepted

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, low = 0, high = n - 1;
        if(n == 0) return 0;
        while(low < high) {
            int mid = low + ((high - low) / 2);
            if((mid - low) % 2 == 0) {
                if(nums[mid - 1] == nums[mid]) high = mid - 2;
                else low = mid + 2;
            } else {
                if(nums[mid - 1] == nums[mid]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return nums[low];
    }
}
