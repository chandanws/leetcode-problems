// Problem link: https://leetcode.com/problems/subarray-product-less-than-k/description/
// Status: Accepted

int numSubarrayProductLessThanK(int* nums, int numsSize, int k) {
    int i = 0, j = 0, total = 0;
    long current = 1L;
    for(int i = 0, j = 0; j < numsSize; j++) {
        current *= *(nums+j);
        while(i <= j && current >= k) current /= *(nums+i++);
        total += (j - i) + 1;
    }
    return total;
}
