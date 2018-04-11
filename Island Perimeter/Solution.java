// Problem link: https://leetcode.com/problems/island-perimeter/description/
// Status: Accepted

class Solution {
    public int islandPerimeter(int[][] grid) {
        int height = grid.length, width = grid[0].length;
        if(height == 1 && width == 1) return 4;
        int [][] visited = new int[height][width];
        int [] result = findIsland(grid);
        int row = result[0], col = result[1];
        return helper(row, col, grid, visited, 0);
    }
    private int [] findIsland(int [][] grid) {
        int height = grid.length, width = grid[0].length;
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < width; j++) {
                if(grid[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0}; // should never comes here as test case guaranteed to have one island.
    }
    private int helper(int row, int col, int [][] grid, int [][] visited, int sum) {
        if(visited[row][col] != 0) return 0;
        else if(grid[row][col] == 0) return 1;
        visited[row][col] = 1;
        // up
        if(row == 0) sum++;
        else sum += helper(row - 1, col, grid, visited, 0);
        // down
        if(row == grid.length - 1) sum++;
        else sum += helper(row + 1, col, grid, visited, 0);
        // right
        if(col == grid[0].length - 1) sum++;
        else sum += helper(row, col + 1, grid, visited, 0);
        // left
        if(col == 0) sum++;
        else sum += helper(row, col - 1, grid, visited, 0);
        return sum;
    }
}
