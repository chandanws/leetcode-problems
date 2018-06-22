// Problem link: https://leetcode.com/problems/missing-number/description/
// Status: Accepted

int missingNumber(int *nums, int numsSize) {
    int remainBit = 0;
    for(int i = 0; i < numsSize; i++) {
        remainBit ^= (i + 1) ^ *(nums + i);
    }
    return remainBit;
}
