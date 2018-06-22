// Problem link: https://leetcode.com/problems/valid-palindrome/description/
// Status: Accepted

bool isAlphanumeric(char c) {
    return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9';
}

bool isPalindrome(char* s) {
    int j = strlen(s) - 1;
    for(int i = 0; i < j; i++, j--) {
        while(!isAlphanumeric(*(s + i)) && i < j) i++;
        while(!isAlphanumeric(*(s + j)) && i < j) j--;
        if(tolower(*(s + i)) != tolower(*(s + j))) return false;
    }
    return true;
}
