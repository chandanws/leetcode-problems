// Problem link: https://leetcode.com/problems/excel-sheet-column-number/description/
// Status: Accepted

class Solution {
    public int titleToNumber(String s) {
        int res = 0, len = s.length() - 1;
        for(char c : s.toCharArray()) {
            res = (int) (Math.pow(26, len--)) * ((c - 'A') + 1) + res;
        }
        return res;
    }
}
