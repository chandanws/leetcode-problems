// Problem link: https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
// Status: Accepted

int peakIndexInMountainArray(int* A, int ASize) {
    int i = 1;
    while(i < ASize - 1) {
        if(*(A+i-1) < *(A+i) && *(A+i) > *(A+i+1)) break;
        i++;
    }
    return i;
}
