// Problem link: https://leetcode.com/problems/rotate-array/description/
// Status: Accepted

class Solution {
    private void reverse(int [] nums, int from, int to) {
        int i = from, j = to - 1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums, k, nums.length);
    }
}
