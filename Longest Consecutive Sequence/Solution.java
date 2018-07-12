// Problem link: https://leetcode.com/problems/longest-consecutive-sequence/description/
// Status: Accepted

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int num : nums) hs.add(num);
        int max = 0;
        for(int num : nums) {
            int i = 0;
            while(hs.contains(num + 1 * i)) {
                hs.remove(num + 1 * i);
                i++;
            }
            int j = 1;
            while(hs.contains(num - 1 * j)) {
                hs.remove(num - 1 * j);
                j++;
            }
            if(i > 0) j--;
            max = Math.max(max, i + j);
        }
        return max;
    }
}
