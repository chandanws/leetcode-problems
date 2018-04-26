// Problem link: https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
// Status: Accepted

class Solution {
    private StringBuilder reverseString(String s) {
        int len = s.length();
        StringBuilder res = new StringBuilder();
        for(int i = len - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res;
    }
    public String reverseWords(String s) {
        String [] words = s.split(" ");
        int len = words.length;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < len; i++) {
            res.append(reverseString(words[i]));
            res.append(" ");
        }
        return res.toString().trim();
    }
}
