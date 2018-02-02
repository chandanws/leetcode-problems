// Problem link: https://leetcode.com/problems/rotate-array/description/
// Status: Accepted

class Solution {
    public int [] reverseArr(int [] nums, int i, int j) {
        int temp = 0;
        while(i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2) { return; }
        k = k % nums.length;
        nums = reverseArr(nums, nums.length - k, nums.length - 1);
        nums = reverseArr(nums, 0, nums.length - k - 1);
        nums = reverseArr(nums, 0, nums.length - 1);
    }
}
