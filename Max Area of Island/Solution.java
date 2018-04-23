// Problem link: https://leetcode.com/problems/max-area-of-island/description/
// Status: Accepted

class Solution {
    private int dfs(int i, int j, int [][] grid) {
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            return 1 + dfs(i - 1, j, grid) +
                       dfs(i + 1, j, grid) +
                       dfs(i, j + 1, grid) +
                       dfs(i, j - 1, grid);
        }
        return 0;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    if(area > maxArea) maxArea = area;
                }
            }
        }
        return maxArea;
    }
}
