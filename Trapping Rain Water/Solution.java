// Problem link: https://leetcode.com/problems/trapping-rain-water/description/
// Status: Accepted


class Solution {
    public int trap(int[] height) {
        int h = Integer.MIN_VALUE;
        int [] water = new int[height.length];
        for(int i = 0; i < height.length; i++) {
            if(height[i] < h) water[i] = h - height[i];
            else h = height[i];
        }
        h = Integer.MIN_VALUE;
        for(int i = height.length - 1; i >= 0; i--) {
            if(height[i] < h) water[i] = Math.min(water[i], h - height[i]);
            else {
                h = height[i];
                if(water[i] > 0) water[i] = 0;
            }
        }
        int sum = 0;
        for(int i = 0; i < height.length; i++) sum += water[i];
        return sum;
    }
}
