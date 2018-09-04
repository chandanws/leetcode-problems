// Problem link: https://leetcode.com/problems/find-peak-element/description/
// Status: Accepted

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
            if(low == high) return low;
            int mid = low + ((high - low) / 2);
            if(nums[mid] < nums[mid + 1]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
