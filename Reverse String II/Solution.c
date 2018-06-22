// Problem link: https://leetcode.com/problems/reverse-string-ii/description/
// Status: Accepted

char* reverse(int i, int j, char *s) {
    while(i < j) {
        char c = *(s + i);
        *(s + i) = *(s + j);
        *(s + j) = c;
        i++;
        j--;
    }
    return s;
}

char* reverseStr(char* s, int k) {
    int sLen = strlen(s);
    for(int i = 0; i < sLen; i += 2 * k) {
        int j = i + k - 1 < sLen ? i + k - 1 : sLen - 1;
        s = reverse(i, j, s);
    }
    return s;
}
