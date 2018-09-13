// Problem link: https://leetcode.com/problems/longest-increasing-subsequence/description/
// Status: Accepted

class Solution {
    private int binarySearch(int [] arr, int startIndex, int endIndex, int target) {
        int low = startIndex, high = endIndex - 1;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(arr[mid] == target) return mid;
            if(arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -(low + 1);
    }
    public int lengthOfLIS(int [] nums) {
        if(nums.length == 0) return 0;
        int [] dp = new int[nums.length];
        int len = 0;
        for(int num : nums) {
            int i = binarySearch(dp, 0, len, num);
            if(i < 0) i = -(i) - 1;
            dp[i] = num;
            if(i == len) len++;
        }
        return len;
    }
}
