// Problem link: https://leetcode.com/problems/unique-paths-ii/description/
// Status: Accepted

class Solution {
    private int get(int [][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        return grid[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length, walk = 1;
        int [][] pathsArray = new int[m][n];
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) walk = -1;
            pathsArray[0][i] = walk;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) pathsArray[i][j] = -1;
                else {
                    int res = 0;
                    int up = get(pathsArray, i, j - 1);
                    int left = get(pathsArray, i - 1, j);
                    if(up != -1) res += up;
                    if(left != -1) res += left;
                    pathsArray[i][j] = res;
                }
            }
        }
        if(pathsArray[m - 1][n - 1] == -1) return 0;
        return pathsArray[m - 1][n - 1];
    }
}
