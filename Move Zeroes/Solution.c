// Problem link: https://leetcode.com/problems/move-zeroes/description/
// Status: Accepted

void moveZeroes(int* nums, int numsSize) {
    int lastWholeNumIndex = 0;
    for(int i = 0; i < numsSize; i++) {
        if(*(nums+i) != 0) *(nums+lastWholeNumIndex++) = *(nums+i);
    }
    for(int i = lastWholeNumIndex; i < numsSize; i++) *(nums+i) = 0;
}
