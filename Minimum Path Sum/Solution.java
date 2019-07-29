// Problem link: https://leetcode.com/problems/minimum-path-sum/description/
// Status: Accepted

class Solution {
    public boolean isValidCoord(int [][] grid, int i, int j) {
        return i < grid.length && j < grid[0].length;
    }
    public void dfs(int [][] grid, int [][] seen, int i, int j) {
        if(i == grid.length - 1 && j == grid[0].length - 1) {
            seen[i][j] = grid[i][j];
            return;
        }
        if(isValidCoord(grid, i, j + 1) && seen[i][j + 1] == Integer.MAX_VALUE) {
            dfs(grid, seen, i, j + 1);
            if(isValidCoord(grid, i + 1, j)) {
                seen[i][j] = grid[i][j] + Math.min(seen[i][j + 1], seen[i + 1][j]);
            } else {
                seen[i][j] = grid[i][j] + seen[i][j + 1];
            }
        } else if(isValidCoord(grid, i, j + 1) && grid[i][j] + seen[i][j + 1] < seen[i][j]) {
            seen[i][j] = grid[i][j] + seen[i][j + 1];
        }
        if(isValidCoord(grid, i + 1, j) && seen[i + 1][j] == Integer.MAX_VALUE) {
            dfs(grid, seen, i + 1, j);
            if(isValidCoord(grid, i, j + 1)) {
                seen[i][j] = grid[i][j] + Math.min(seen[i][j + 1], seen[i + 1][j]);
            } else {
                seen[i][j] = grid[i][j] + seen[i + 1][j];
            }
        } else if(isValidCoord(grid, i + 1, j) && grid[i][j] + seen[i + 1][j] < seen[i][j]) {
            seen[i][j] = grid[i][j] + seen[i + 1][j];
        }
    }
    public int minPathSum(int [][] grid) {
        int [][] seen = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) seen[i][j] = Integer.MAX_VALUE;
        }
        dfs(grid, seen, 0, 0);
        return seen[0][0];
    }
}
