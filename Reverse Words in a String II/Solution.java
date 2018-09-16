// Problem link: https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
// Status: Accepted

class Solution {
    private void reverse(char [] str, int i, int j) {
        while(i < j) {
            char c = str[i];
            str[i] = str[j];
            str[j] = c;
            i++;
            j--;
        }
    }
    public void reverseWords(char [] str) {
        reverse(str, 0, str.length - 1);
        int i = 0, j = 0;
        while(i < str.length) {
            while(j + 1 < str.length && str[j + 1] != ' ') j++;
            reverse(str, i, j);
            j+=2;
            i = j;
        }
    }
}
