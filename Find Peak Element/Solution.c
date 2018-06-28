// Problem link: https://leetcode.com/problems/find-peak-element/description/
// Status: Accepted

int helper(int* nums, int start, int end) {
    if(start == end) return start;
    int middle = (start + end) / 2;
    if(*(nums+middle) < *(nums+middle+1))
        return helper(nums, middle + 1, end);
    return helper(nums, start, middle);
}

int findPeakElement(int* nums, int numsSize) {
    return helper(nums, 0, numsSize - 1);
}
