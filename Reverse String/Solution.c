// Problem link: https://leetcode.com/problems/reverse-string/description/
// Status: Accepted

char* reverseString(char* s) {
    int j = strlen(s) - 1;
    for(int i = 0; i < j; i++, j--) {
        char c = *(s + i);
        *(s + i) = *(s + j);
        *(s + j) = c;
    }
    return s;
}
