// Problem link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// Status: Accepted

int findMin(int* nums, int numsSize) {
    int low = 0, high = numsSize - 1;
    while(low < high) {
        int mid = low + ((high - low) / 2);
        if(mid + 1 < numsSize && *(nums+mid) > *(nums+mid+1)) return *(nums+mid+1);
        if(*(nums+low) < *(nums+mid)) low = mid + 1;
        else high = mid;
    }
    return *nums;
}
