// Problem link: https://leetcode.com/problems/add-digits/description/
// Status: Accepted

class Solution {
    private int getSmallestNum(int [] nums) {
        int smallestNum = 0, len = nums.length;
        for(int i = 0; i < len; i++) {
            if(nums[i] < smallestNum) smallestNum = nums[i];
        }
        return Math.abs(smallestNum) + 1; // always add one here because zero cannot be negative
    }
    private int evenTheNegNum(int [] nums) {
        int smallestNum = getSmallestNum(nums), len = nums.length;
        if(smallestNum == 0) return smallestNum;
        for(int i = 0; i < len; i++) {
            nums[i] += smallestNum;
        }
        return smallestNum;
    }
    public int firstMissingPositive(int[] nums) {
        int len = nums.length, diff = evenTheNegNum(nums); // for example, -5 becomes 1 with diff of 6
        for(int i = 0; i < len; i++) {
            int index = Math.abs(nums[i]) - diff - 1;
            if(index >= 0 && index < len && nums[index] > 0) nums[index] *= -1;
        }
        int res = 0;
        while(res < len) {
            if(nums[res] < 0) res++;
            else break;
        }
        return res + 1;
    }
}
