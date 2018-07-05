// Problem link: https://leetcode.com/problems/score-after-flipping-matrix/description/
// Status: Accepted

class Solution {
    private int [][] flipColIfNec(int [][] A, int i) {
        int numsOf1s = 0, numsOf0s = 0;
        for(int j = 0; j < A.length; j++) {
            if(A[j][i] == 1) numsOf1s++;
            else numsOf0s++;
        }
        if(numsOf1s > numsOf0s) return A;
        for(int j = 0; j < A.length; j++) A[j][i] = A[j][i] == 0 ? 1 : 0;
        return A;
    }
    private int [][] flipRowIfNec(int [][] A) {
        for(int i = 0; i < A.length; i++) {
            if(A[i][0] == 0) for(int j = 0; j < A[0].length; j++) A[i][j] = A[i][j] == 0 ? 1 : 0;
        }
        return A;
    }
    private int getSum(int [][] A) {
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                sum += A[i][j] * Math.pow(2, A[0].length - 1 - j);
            }
        }
        return sum;
    }
    public int matrixScore(int[][] A) {
        flipRowIfNec(A);
        for(int j = 0; j < A[0].length; j++) flipColIfNec(A, j);
        return getSum(A);
    }
}
