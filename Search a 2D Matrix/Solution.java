// Problem link: https://leetcode.com/problems/search-a-2d-matrix/description/
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
        int possibleRow = matrix.length - 1;
        for(int i = 0; i < matrix.length; i++) {
          if(matrix[i][0] == target) return true;
          if(matrix[i][0] > target) { possibleRow = i - 1; break; }
        }
        for(int i = 1; i < matrix[0].length; i++) {
          if(matrix[possibleRow][i] == target) return true;
        }
        return false;
    }
}
