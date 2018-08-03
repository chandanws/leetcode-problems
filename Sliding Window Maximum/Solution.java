// Problem link: https://leetcode.com/problems/sliding-window-maximum/description/
// Status: Accepted

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        Queue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++) pq.offer(nums[i]);
        int open = 0, close = k - 1;
        while(close < nums.length) {
            res.add((int) pq.peek());
            pq.remove(nums[open]);
            open++;
            close++;
            if(close < nums.length) pq.add(nums[close]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
