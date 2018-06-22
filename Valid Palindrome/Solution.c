// Problem link: https://leetcode.com/problems/valid-palindrome/description/
// Status: Accepted

bool isAlphanumeric(char c) {
    return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
}

bool isPalindrome(char* s) {
    int i = 0, j = strlen(s) - 1;
    while(i < j) {
        while(!isAlphanumeric(tolower(*(s + i))) && i < j) i++;
        while(!isAlphanumeric(tolower(*(s + j))) && i < j) j--;
        if(tolower(*(s + i)) != tolower(*(s + j))) return false;
        i++;
        j--;
    }
    return true;
}
