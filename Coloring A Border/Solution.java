// Problem link: https://leetcode.com/problems/coloring-a-border/description/
// Status: Accepted

class Solution {
    public List<List<Integer>> borders;
    public boolean isInValidCoord(int [][] grid, int i, int j, int color) {
        return i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != color;
    }
    public void dfs(int [][] grid, int i, int j, int color, HashSet<String> seen) {
        if(isInValidCoord(grid, i, j, color) || seen.contains(i + "," + j)) return;
        boolean isInside = true;
        int [][] directions = new int[][]{{i - 1, j}, {i, j - 1}, {i, j + 1}, {i + 1, j}};
        for(int k = 0; k < 4 && isInside; k++) {
            if(isInValidCoord(grid, directions[k][0], directions[k][1], color)) isInside = false;
        }
        seen.add(i + "," + j);
        if(!isInside) borders.add(new ArrayList<Integer>(Arrays.asList(i, j)));
        dfs(grid, i, j - 1, color, seen);
        dfs(grid, i, j + 1, color, seen);
        dfs(grid, i - 1, j, color, seen);
        dfs(grid, i + 1, j, color, seen);
    }
    public int[][] colorBorder(int [][] grid, int r0, int c0, int color) {
        borders = new ArrayList<>();
        HashSet<String> seen = new HashSet<String>();
        dfs(grid, r0, c0, grid[r0][c0], seen);
        for(List<Integer> coord : borders) grid[coord.get(0)][coord.get(1)] = color;
        return grid;
    }
}
