// Problem link: https://leetcode.com/problems/reverse-string-ii/description/
// Status: Accepted

class Solution {
    private char [] reverse(int i, int j, char [] strInChar) {
        while(i < j) {
            char c = strInChar[i];
            strInChar[i] = strInChar[j];
            strInChar[j] = c;
            i++;
            j--;
        }
        return strInChar;
    }
    public String reverseStr(String s, int k) {
        int sLen = s.length();
        char [] strInChar = s.toCharArray();
        for(int i = 0; i < sLen; i += 2 * k) {
            int j = i + k - 1 < sLen ? i + k - 1 : sLen - 1;
            strInChar = reverse(i, j, strInChar);
        }
        return String.valueOf(strInChar);
    }
}
