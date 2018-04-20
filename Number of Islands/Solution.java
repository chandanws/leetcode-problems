// Problem link: https://leetcode.com/problems/number-of-islands/description/
// Status: Accepted

class Solution {
    private void exploreTheIsland(int i, int j, char [][] grid) {
        if(i > -1 && j > -1 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '2';
            exploreTheIsland(i, j - 1, grid); // up
            exploreTheIsland(i, j + 1, grid); // down
            exploreTheIsland(i + 1, j, grid); // right
            exploreTheIsland(i - 1, j, grid); // left
        }
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(grid == null || rows == 0) return 0;
        int cols = grid[0].length, numIslands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    exploreTheIsland(i, j, grid);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
}
