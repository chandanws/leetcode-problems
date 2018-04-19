// Problem link: https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
// Status: Accepted

class Solution {
    private void reverseString(char [] str, int i, int j) {
        while(i != j) {
            char c = str[i];
            str[i] = str[j];
            str[j] = c;
            if(i + 1 == j) break;
            i++;
            j--;
        }
    }
    public void reverseWords(char [] str) {
        int len = str.length;
        if(str == null || len < 2) return;
        reverseString(str, 0, len - 1);
        int i = 0, j = 0;
        while(i < len - 1 || j < len -1) {
            while(j + 1 < len && str[j + 1] != ' ') j++;
            reverseString(str, i, j);
            j += 2;
            i = j;
        }
    }
}
