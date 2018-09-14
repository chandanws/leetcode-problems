// Problem link: https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
// Status: Accepted

class Solution {
    public String reverseWords(String s) {
        int i = 0, j = 0;
        char [] sCharArr = s.toCharArray();
        while(i < sCharArr.length) {
            while(j < sCharArr.length && sCharArr[j] != ' ') j++;
            int start = i, end = j - 1;
            while(start < end) {
                char c = sCharArr[start];
                sCharArr[start] = sCharArr[end];
                sCharArr[end] = c;
                start++;
                end--;
            }
            j++;
            i = j;
        }
        return new String(sCharArr);
    }
}
