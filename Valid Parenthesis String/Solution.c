// Problem link: https://leetcode.com/problems/valid-parenthesis-string/description/
// Status: Accepted

bool checkValidString(char* s) {
    int* range = (int*) calloc(sizeof(int), 2);
    int i = 0;
    while(*(s+i) != '\0') {
        if(*(s+i) == '(') {
            *(range+0) = *(range+0) + 1;
            *(range+1) = *(range+1) + 1;
        } else if(*(s+i) == ')') {
            if(*(range+0) == 0 && *(range+1) == 0) return false;
            if(*(range+0) > 0 && *(range+1) > 0) {
                *(range+0) = *(range+0) - 1;
                *(range+1) = *(range+1) - 1;
            } else {
                *(range+1) = *(range+1) - 1;
            }
        } else {
            if(*(range+0) > 0) *(range+0) = *(range+0) - 1;
            *(range+1) = *(range+1) + 1;
        }
        i++;
    }
    return *(range+0) <= 0 && 0 <= *(range+1);
}
