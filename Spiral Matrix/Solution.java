// Problem link: https://leetcode.com/problems/spiral-matrix/description/
// Status: Accepted

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if(m == 0) return res;
        int n = matrix[0].length, len = m * n;
        int [][] visited = new int[m][n];
        visited[0][0] = 1;
        res.add(matrix[0][0]);
        int i = 0, j = 0;
        while(res.size() < len) {
            while(j + 1 < n && visited[i][j + 1] == 0) {
                // keep going right
                res.add(matrix[i][j + 1]);
                visited[i][j + 1] = 1;
                j++;
            }
            while(i + 1 < m && visited[i + 1][j] == 0) {
                // keep going down
                res.add(matrix[i + 1][j]);
                visited[i + 1][j] = 1;
                i++;
            }
            while(j - 1 >= 0 && visited[i][j - 1] == 0) {
                // keep going left
                res.add(matrix[i][j - 1]);
                visited[i][j - 1] = 1;
                j--;
            }
            while(i - 1 >= 0 && visited[i - 1][j] == 0) {
                // keep going up
                res.add(matrix[i - 1][j]);
                visited[i - 1][j] = 1;
                i--;
            }
        }
        return res;
    }
}
