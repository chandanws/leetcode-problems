// Problem link: https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/
// Status: Accepted

int helper(int *A, int L, int start, int end) {
    int n = end - start;
    int permutationCount = n * (n + 1) / 2;
    for(int j = start; j < end; j++) {
        int count = 0;
        while(j < end && *(A+j) < L) {
            j++;
            count++;
        }
        if(count > 0) {
            int k = j - (j - count);
            permutationCount -= k * (k + 1) / 2;
        }
    }
    return permutationCount;
}

int numSubarrayBoundedMax(int* A, int ASize, int L, int R) {
    int start = 0, end = 0, answer = 0;
    while(end < ASize) {
        if(*(A+end) > R) {
            answer += helper(A, L, start, end);
            start = end + 1;
        }
        end++;
    }
    answer += helper(A, L, start, end);
    return answer;
}
