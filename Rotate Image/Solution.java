// Problem link: https://leetcode.com/problems/rotate-image/description/
// Status: Accepted

class Solution {
  public void rotate(int[][] matrix) {
    if(matrix == null || matrix[0].length < 2) { return; }
    for(int i = 0; i < matrix[0].length; i++) {
      for(int j = i + 1; j < matrix[0].length; j++) {
        int temp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }
    for(int i = 0; i < matrix[0].length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        if(j < matrix[0].length - j - 1) {
          int temp = matrix[i][j];
          matrix[i][j] = matrix[i][matrix[0].length - j - 1];
          matrix[i][matrix[0].length - j - 1] = temp;
        }
      }
    }
  }
}
