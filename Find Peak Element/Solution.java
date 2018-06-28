// Problem link: https://leetcode.com/problems/find-peak-element/description/
// Status: Accepted

class Solution {
    private int helper(int [] nums, int start, int mid, int end) {
        if(nums[start] > nums[start + 1]) return start;
        if(nums[end] > nums[end - 1]) return end;
        if(nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) return mid;
        if(nums[start] > nums[mid] && nums[mid] > nums[end]) {
            return helper(nums, start, (int) (mid - start) / 2 + start, mid);
        } else if(nums[start] <= nums[mid] && nums[mid] >= nums[end]) {
            if(nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                return helper(nums, mid, (int) (end - mid) / 2 + mid, end);
            }
            return helper(nums, start, (int) (mid - start) / 2 + start, mid);
        }
        return helper(nums, mid, (int) (end - mid) / 2 + mid, end);
    }
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1) return 0;
        return helper(nums, 0, (int) len / 2, len - 1);
    }
}
