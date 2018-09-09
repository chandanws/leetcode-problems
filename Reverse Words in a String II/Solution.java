// Problem link: https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
// Status: Accepted

class Solution {
    private void reverseWord(char[] str, int i, int j) {
        while(i < j) {
            char c = str[i];
            str[i] = str[j];
            str[j] = c;
            i++;
            j--;
        }
    }
    public void reverseWords(char[] str) {
        reverseWord(str, 0, str.length - 1);
        int i = 0, j = 0;
        while(j < str.length) {
            j = i;
            while(j < str.length && str[j] != ' ') j++;
            reverseWord(str, i, j - 1);
            i = j + 1;
        }
    }
}
