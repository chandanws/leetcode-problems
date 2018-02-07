// Problem link: https://leetcode.com/problems/search-a-2d-matrix-ii/description/
// Status: Accepted

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null ||
          matrix.length == 0 ||
          matrix[0].length == 0 ||
          matrix[0][0] > target ||
          matrix[matrix.length - 1][matrix[0].length - 1] < target) { 
          return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j > -1) {
          if(matrix[i][j] == target) {
            return true;
          } else if(matrix[i][j] > target) {
            j--;
          } else if(matrix[i][j] < target) {
            i++;
          }
        }
        return false;
    }
}
