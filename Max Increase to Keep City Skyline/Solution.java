// Problem link: https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/
// Status: Accepted

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int a = 0;
        int [] rows = new int[grid.length];
        for(int i = 0; i < grid.length; i++) {
            int maxInRows = grid[i][0];
            for(int j = 0; j < grid[0].length; j++) maxInRows = Math.max(grid[i][j], maxInRows);
            rows[a++] = maxInRows;
        }
        a = 0;
        int [] cols = new int[grid[0].length];
        for(int i = 0; i < grid[0].length; i++) {
            int maxInCols = grid[0][i];
            for(int j = 0; j < grid.length; j++) maxInCols = Math.max(grid[j][i], maxInCols);
            cols[a++] = maxInCols;
        }
        int sumAdded = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                sumAdded += Math.min(rows[i], cols[j]) - grid[i][j];
            }
        }
        return sumAdded;
    }
}
