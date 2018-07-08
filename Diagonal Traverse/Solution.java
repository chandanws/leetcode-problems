// Problem link: https://leetcode.com/problems/diagonal-traverse/description/
// Status: Accepted

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int i = 0, j = 0, m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length, numOfEle = m * n, k = 1;
        int [] ans = new int[numOfEle];
        if(numOfEle == 0) return ans;
        ans[0] = matrix[0][0];
        boolean goRight = true;
        while(k < numOfEle) {
            if(goRight) {
                // try right up
                if((i - 1) >= 0 && (i - 1) < m && (j + 1) >= 0 && (j + 1) < n) {
                    ans[k] = matrix[i - 1][j + 1];
                    i = i - 1;
                    j = j + 1;
                } else if((j + 1) >= 0 && (j + 1) < n) {
                    // go right
                    ans[k] = matrix[i][j + 1];
                    j = j + 1;
                    goRight = false;
                } else if((i + 1) >= 0 && (i + 1) < m) {
                    // go down
                    ans[k] = matrix[i + 1][j];
                    i = i + 1;
                    goRight = false;
                }
            } else {
                // try left down
                if((i + 1) >= 0 && (i + 1) < m && (j - 1) >= 0 && (j - 1) < n) {
                    ans[k] = matrix[i + 1][j - 1];
                    i = i + 1;
                    j = j - 1;
                } else if((i + 1) >= 0 && (i + 1) < m) {
                    // go down
                    ans[k] = matrix[i + 1][j];
                    i = i + 1;
                    goRight = true;
                } else if((j + 1) >= 0 && (j + 1) < n) {
                    // go right
                    ans[k] = matrix[i][j + 1];
                    j = j + 1;
                    goRight = true;
                }
            }
            k++;
        }
        return ans;
    }
}
