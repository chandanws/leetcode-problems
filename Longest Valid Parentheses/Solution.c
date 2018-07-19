// Problem link: https://leetcode.com/problems/longest-valid-parentheses/
// Status: Accepted

int longestValidParentheses(char* s) {
    int left = 0, right = 0, maxLength = 0, n = strlen(s);
    for(int i = 0; i < n; i++) {
        if(*(s+i) == '(') left++;
        else right++;
        if(left == right) {
            if(maxLength < right * 2) maxLength = right * 2;
        } else if(left < right) {
            right = 0;
            left = 0;
        }
    }
    left = 0, right = 0;
    for(int i = n - 1; i >= 0; i--) {
        if(*(s+i) == '(') left++;
        else right++;
        if(left == right) {
            if(maxLength < right * 2) maxLength = right * 2;
        } else if(left > right) {
            right = 0;
            left = 0;
        }
    }
    return maxLength;
}
