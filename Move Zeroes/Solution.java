// Problem link: https://leetcode.com/problems/move-zeroes/description/
// Status: Accepted

class Solution {
    public static void swap(int a, int b, int [] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void moveZeroes(int[] nums) {
        boolean hasZero = false;
        int lastNonZeroIndex = nums[0] == 0 ? -1 : 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0 && hasZero) swap(++lastNonZeroIndex, i, nums);
            if(nums[i] != 0 && !hasZero && i != 0) lastNonZeroIndex++;
            if(nums[i] == 0) hasZero = true;
        }
    }
}
