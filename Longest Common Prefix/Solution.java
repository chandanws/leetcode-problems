// Problem link: https://leetcode.com/problems/longest-common-prefix/description/
// Status: Accepted

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++) min = Math.min(min, strs[i].length());
        int longestComPrefx = 0;
        for(int i = 0; i < min; i++) {
            char candidate = strs[0].charAt(i);
            boolean commonPrefx = true;
            for(int j = 1; j < strs.length && commonPrefx; j++) {
                if(strs[j].charAt(i) != candidate) commonPrefx = false;
            }
            if(commonPrefx) longestComPrefx++;
            else break;
        }
        return strs[0].substring(0, longestComPrefx);
    }
}
