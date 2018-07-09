// Problem link: https://leetcode.com/problems/sort-colors/description/
// Status: Accepted

void swap(int* nums, int i, int j) {
    int temp = *(nums+i);
    *(nums+i) = *(nums+j);
    *(nums+j) = temp;
}

void sortColors(int* nums, int numsSize) {
    int i = 0, j = 0;
    numsSize--;
    while(j <= numsSize) {
        if(*(nums+j) == 2) {
            swap(nums, j, numsSize);
            numsSize--;
        } else if(*(nums+j) == 0) {
            swap(nums, i, j);
            i++;
            j++;
        } else {
            j++;
        }
    }
}
