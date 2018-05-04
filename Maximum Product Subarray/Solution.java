// Problem link: https://leetcode.com/problems/maximum-product-subarray/description/
// Status: Accepted

class Solution {
    public int maxProduct(int[] nums) {
        int prod = 0, len = nums.length, maxProd = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
            if(prod == 0) prod = nums[i];
            else prod *= nums[i];
            maxProd = Math.max(maxProd, prod);
        }
        prod = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(prod == 0) prod = nums[i];
            else prod *= nums[i];
            maxProd = Math.max(maxProd, prod);
        }
        return maxProd;
    }
}
