// Problem link: https://leetcode.com/problems/score-of-parentheses/description/
// Status: Accepted

int scoreOfParentheses(char* S) {
    int maxSize = strlen(S);
    int *stack = (int *) malloc(sizeof(int) * maxSize);
    int stackSize = 0;
    for(int i = 0; i < maxSize; i++) {
        if(*(S+i) == '(') {
            *(stack+stackSize++) = -1;
        } else if(*(S+i) == ')') {
            if(*(stack+stackSize-1) == -1) *(stack+stackSize-1) = 1;
            else *(stack+stackSize-2) = *(stack+--stackSize) * 2;
            while(stackSize > 1 && *(stack+stackSize-1) != -1 && *(stack+stackSize-2) != -1) {
                stackSize--;
                *(stack+stackSize-1) += *(stack+stackSize);
            }
        }
    }
    return *stack;
}
