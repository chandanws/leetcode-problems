// Problem link: https://leetcode.com/problems/third-maximum-number/description/
// Status: Accepted

class Solution {
    public int thirdMax(int[] nums) {
        int [] largestThrees = new int[]{-1, -1, -1};
        int len = nums.length;
        for(int k = 0; k < len; k++) {
            boolean hasSeen = false;
            for(int index : largestThrees) if(index != -1 && nums[index] == nums[k]) hasSeen = true;
            if(hasSeen) continue;
            int replacedIndex = k;
            for(int i = 2; i >= 0; i--) {
                if(largestThrees[i] == -1 || nums[replacedIndex] > nums[largestThrees[i]]) {
                    int tempIndex = largestThrees[i];
                    largestThrees[i] = replacedIndex;
                    replacedIndex = tempIndex;
                }
            }
        }
        if(largestThrees[0] != -1) return nums[largestThrees[0]];
        int i = 2;
        while(i >= 0) {
            if(largestThrees[i] != -1) break;
            i--;
        }
        return nums[largestThrees[i]];
    }
}
