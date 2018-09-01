// Problem link: https://leetcode.com/problems/product-of-array-except-self/description/
// Status: Accepted

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] res = new int[nums.length];
        if(nums.length == 1) return new int[]{1};
        res[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            res[i] = nums[i] * res[i - 1];
        }
        for(int i = nums.length - 2; i >= 0; i--) {
            nums[i] *= nums[i + 1];
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1) res[i] = res[i - 1];
            else if(i == 0) res[i] = nums[i + 1];
            else res[i] = res[i - 1] * nums[i + 1];
        }
        return res;
    }
}
