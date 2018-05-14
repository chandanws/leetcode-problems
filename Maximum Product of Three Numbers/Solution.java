// Problem link: https://leetcode.com/problems/next-permutation/description/
// Status: Accepted

class Solution {
    private int helper(int [] nums) {
        int result = 1, len = nums.length;
        for(int i = 1; i < 4; i++) result *= nums[len - i];
        return result;
    }
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, result = 1;
        if(nums[0] >= 0 || nums[len - 1] < 0) {
            result = helper(nums);
        } else {
            if(nums[len - 2] > 0 && nums[len - 3] > 0 && nums[0] < 0 && nums[1] < 0) {
                result = nums[len - 1];
                int posProd = nums[len - 2] * nums[len - 3];
                int negProd = nums[0] * nums[1];
                if(posProd > negProd) result *= posProd;
                else result *= negProd;
            } else if(!(nums[len - 2] > 0 && nums[len - 3] > 0) && nums[0] < 0 && nums[1] < 0) {
                result = nums[len - 1] * nums[0] * nums[1];
            } else {
                result = helper(nums);
            }
        }
        return result;
    }
}
