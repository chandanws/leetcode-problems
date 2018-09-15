// Problem link: https://leetcode.com/problems/rotate-image/description/
// Status: Accepted

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return;
        for(int i = 0; i < n; i++) {
            int top = 0, bottom = n - 1;
            while(bottom > top) {
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;
                top++;
                bottom--;
            }
        }
        for(int i = n - 1; i > 0; i--) {
            int x = i, y = 0;
            while(x > y) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
                x--;
                y++;
            }
        }
        for(int i = 1; i < n - 1; i++) {
            int x = n - 1, y = i;
            while(x > y) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
                x--;
                y++;
            }
        }
    }
}
