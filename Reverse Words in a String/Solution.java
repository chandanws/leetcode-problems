// Problem link: https://leetcode.com/problems/add-digits/description/
// Status: Accepted

public class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s{2,}", " ");
        int strLen = s.length();
        if(s == null || strLen < 2) return s;
        StringBuilder res = new StringBuilder();
        String [] stringArray = s.split(" ");
        int wordLen = stringArray.length;
        for(int i = wordLen - 1; i >= 0; i--) {
            res.append(stringArray[i]);
            if(i > 0) res.append(" ");
        }
        return res.toString();
    }
}
