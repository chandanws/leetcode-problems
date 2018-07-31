// Problem link: https://leetcode.com/problems/container-with-most-water/description/
// Status: Accepted

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = Integer.MIN_VALUE;
        while(left < right) {
            if(height[left] < height[right]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            } else {
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }
}
