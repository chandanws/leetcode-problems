// Problem link: https://leetcode.com/problems/shifting-letters/description/
// Status: Accepted

char shift(char c, int times) {
    return (((c-97)+times)%26)+97;
}

char* shiftingLetters(char* S, int* shifts, int shiftsSize) {
    char* res = (char *) malloc((shiftsSize + 1) * sizeof(char));
    *(res+shiftsSize) = '\0';
    for(int i = shiftsSize - 2; i >= 0; i--) *(shifts+i) += (*(shifts+i+1) % 26);
    for(int i = 0; i < shiftsSize; i++) *(res+i) = shift(*(S+i), *(shifts+i));
    return res;
}
