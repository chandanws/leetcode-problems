// Problem link: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
// Status: Accepted

class Solution {
    // simply use natively-implemented quick sort algorithm
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    // use priority queue
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        for(int num : nums) pQueue.add(num);
        int len = nums.length;
        for(int i = 0; i < len - k; i++) pQueue.poll();
        return pQueue.poll();
    }
}
