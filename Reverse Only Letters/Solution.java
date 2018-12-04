// Problem link: https://leetcode.com/problems/reverse-only-letters/
// Status: Accepted

class Solution {
    private boolean isLetters(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }
    public String reverseOnlyLetters(String S) {
        char [] arr = S.toCharArray();
        int start = 0, end = arr.length - 1;
        while(start < end) {
            while(!isLetters(arr[start]) && start < end) start++;
            while(!isLetters(arr[end]) && start < end) end--;
            if(start < end) {
                char c = arr[start];
                arr[start] = arr[end];
                arr[end] = c;
                start++;
                end--;
            }
        }
        return new String(arr);
    }
}
