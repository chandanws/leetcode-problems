// Problem link: https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
// Status: Accepted

class Solution {
    // slower when using append along StringBuilder
    private StringBuilder reverseString(String s) {
        int len = s.length();
        StringBuilder res = new StringBuilder();
        for(int i = len - 1; i >= 0; i--) {
            res.append(s.charAt(i));
        }
        return res;
    }
    // faster with swap with 2 pointers
    private String reverseString(String s) {
        int len = s.length(), i = 0, j = len - 1;
        char [] charArray = s.toCharArray();
        while(i != j) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            if(i + 1 == j) break;
            i++;
            j--;
        }
        return String.valueOf(charArray);
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
