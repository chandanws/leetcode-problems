// Problem link: https://leetcode.com/problems/sort-array-by-parity/description/
// Status: Accepted

class Solution {
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length - 1;
        for(int i = 0; i < A.length && left < right;) {
            if(A[i] % 2 == 0) {
                swap(A, i, left);
                left++;
            } else if(A[i] % 2 != 0) {
                swap(A, i, right);
                right--;
            }
            i = left;
        }
        return A;
    }
}
