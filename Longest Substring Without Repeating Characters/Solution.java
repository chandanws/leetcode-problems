// Problem link: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// Status: Accepted

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slidingWindowStartIndex = 0, max = 0;
        HashSet<Character> hs = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(hs.contains(s.charAt(i))) while(hs.contains(s.charAt(i))) hs.remove(s.charAt(slidingWindowStartIndex++));
            hs.add(s.charAt(i));
            max = Math.max(max, hs.size());
        }
        return max;
    }
}
