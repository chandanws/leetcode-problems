// Problem link: https://leetcode.com/problems/search-insert-position/description/
// Status: Accepted

int searchInsert(int* nums, int numsSize, int target) {
    int low = 0, high = numsSize - 1;
    while(low < high) {
        int mid = (int)(high+low) / 2;
        if(*(nums+mid) == target) return mid;
        if(*(nums+mid) > target) high = mid;
        if(*(nums+mid) < target) low = mid + 1;
    }
    if(low+1 == numsSize && *(nums+low) < target) return low+1;
    return low;
}
