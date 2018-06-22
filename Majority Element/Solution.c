// Problem link: https://leetcode.com/problems/majority-element/description/
// Status: Accepted

int majorityElement(int* nums, int numsSize) {
    int majorityNum = *nums, vote = 1;
    for(int i = 1; i < numsSize; i++) {
        if(*(nums + i) == majorityNum) vote++;
        else vote--;
        if(vote == 0) {
            majorityNum = *(nums + ++i);
            vote = 1;
        }
    }
    return majorityNum;
}
