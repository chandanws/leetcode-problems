// Problem link: https://leetcode.com/problems/unique-paths/description/
// Status: Accepted

class Solution {
    public int uniquePaths(int m, int n) {
        int [][] pathsArray = new int[m][n];
        for(int i = 0; i < n; i++) pathsArray[0][i] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(j - 1 >= 0) pathsArray[i][j] += pathsArray[i][j - 1];
                if(i - 1 >= 0) pathsArray[i][j] += pathsArray[i - 1][j];
            }
        }
        return pathsArray[m - 1][n - 1];
    }
}
