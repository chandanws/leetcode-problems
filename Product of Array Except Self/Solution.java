// Problem link: https://leetcode.com/problems/product-of-array-except-self/description/
// Status: Accepted

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) { return nums; }
        if(nums.length == 1) { return new int[]{1}; }
        int [] output = new int[nums.length];
        int times = 1;
        for(int i = 0; i < nums.length; i++) {
          times *= nums[i];
          output[i] = times;
        }
        times = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
          times *= nums[i];
          nums[i] = times;
        }
        int prevValue = 1;
        for(int i = 0; i < nums.length; i++) {
          if(i == 0) {
            prevValue = output[i];
            output[i] = nums[i + 1];
          } else if(i + 1 == nums.length) {
            output[i] = prevValue;
          } else {
            int temp = output[i];
            output[i] = prevValue * nums[i + 1];
            prevValue = temp;
          }
        }
        return output;
    }
}
