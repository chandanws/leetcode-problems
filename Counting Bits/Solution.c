// Problem link: https://leetcode.com/problems/add-binary/description/
// Status: Accepted

/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* countBits(int num, int* returnSize) {
    int* res = (int*) calloc(sizeof(int), num + 1);
    int n = 1;
    for(int i = 1; i < 31; i++) {
        n *= 2;
        if(n > num) break;
        *(res+n) = 1;
    }
    int lastPowOf2Num = 2;
    for(int i = 0; i <= num; i++) {
        if(i == 0) *(res+0) = 0;
        else if(i == 1) *(res+1) = 1;
        else if(*(res+i) == 1) lastPowOf2Num = i;
        else if(*(res+i) == 0) {
            *(res+i) = *(res+(i-lastPowOf2Num)) + 1;
        }
    }
    *returnSize = num + 1;
    return res;
}
