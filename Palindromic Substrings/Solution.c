// Problem link: https://leetcode.com/problems/palindromic-substrings/description/
// Status: Accepted

int countSubstrings(char* s) {
    int len = strlen(s), ans = 0;
    for(int i = 0; i < len; i++) {
        int left = i, right = i;
        while(left >= 0 && right < len) {
            if(*(s+left) == *(s+right)) ans++;
            else break;
            left--;
            right++;
        }
        left = i, right = i + 1;
        while(left >= 0 && right < len) {
            if(*(s+left) == *(s+right)) ans++;
            else break;
            left--;
            right++;
        }
    }
    return ans;
}
