// Problem link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
// Status: Accepted

class Solution {
    public int binarySearchForRightMost(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]) return mid;
                low = mid + 1;
            } else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return high >= 0 && high < nums.length && nums[high] == target ? high : -1;
    }
    public int binarySearchForLeftMost(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid - 1] < nums[mid]) return mid;
                high = mid - 1;
            } else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low >= 0 && low < nums.length && nums[low] == target ? low : -1;
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearchForLeftMost(nums, target), binarySearchForRightMost(nums, target)};
    }
}
