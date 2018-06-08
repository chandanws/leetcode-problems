// Problem link: https://leetcode.com/problems/sort-colors/description/
// Status: Accepted

class Solution {
    private void swap(int a, int b, int [] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void sortColors(int[] nums) {
        int i = 0, j = 0, n = nums.length - 1;
        while(j <= n) {
            if(nums[j] < 1) {
                swap(i, j, nums);
                i++;
                j++;
            } else if(nums[j] > 1) {
                swap(j, n, nums);
                n--;
            } else {
                j++;
            }
        }
    }
}
