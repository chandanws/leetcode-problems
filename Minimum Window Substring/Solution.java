// Problem link: https://leetcode.com/problems/minimum-window-substring/description/
// Status: Accepted

class Solution {
    private boolean compare(int [] s1, int [] s2) {
        for(int i = 0; i < 94; i++) {
            if(s2[i] > 0 && s1[i] < s2[i]) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length(), l = 0, r = 0;
        if(n == 0 || m == 0) return "";
        int [] tArr = new int[94];
        for(char c : t.toCharArray()) tArr[c - ' ']++;
        int[] ans = {-1, 0, 0};
        int [] slidingWindow = new int[94];
        while(r < n) {
            slidingWindow[s.charAt(r) - ' ']++;
            while(compare(slidingWindow, tArr)) {
                if(ans[0] == -1 || (r - l + 1) < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                slidingWindow[s.charAt(l++) - ' ']--;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
