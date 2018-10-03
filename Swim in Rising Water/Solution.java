// Problem link: https://leetcode.com/problems/swim-in-rising-water/description/
// Status: Accepted

class Solution {
    private void addNeighbours(int [] node,  HashSet<String> visitedNodes, PriorityQueue<int []> unvisitedNodes, int [][] grid) {
        int i = node[0], j = node[1];
        if(i - 1 >= 0 && !visitedNodes.contains((i - 1) + "|" + j)) unvisitedNodes.add(new int[]{i - 1, j, grid[i - 1][j]});
        if(i + 1 < grid.length && !visitedNodes.contains((i + 1) + "|" + j)) unvisitedNodes.add(new int[]{i + 1, j, grid[i + 1][j]});
        if(j - 1 >= 0 && !visitedNodes.contains(i + "|" + (j - 1))) unvisitedNodes.add(new int[]{i, j - 1, grid[i][j - 1]});
        if(j + 1 < grid.length && !visitedNodes.contains(i + "|" + (j + 1))) unvisitedNodes.add(new int[]{i, j + 1, grid[i][j + 1]});
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<int []> unvisitedNodes = new PriorityQueue<int []>(new Comparator<int []>() {
            @Override
            public int compare(int [] node1, int [] node2) {
                return node1[2] - node2[2];
            }
        });
        HashSet<String> visitedNodes = new HashSet<String>();
        unvisitedNodes.add(new int[]{0, 0, grid[0][0]});
        int res = 0;
        while(!visitedNodes.contains((grid.length - 1) + "|" + (grid.length - 1))) {
            int [] currentNode = unvisitedNodes.poll();
            res = Math.max(res, currentNode[2]);
            addNeighbours(currentNode, visitedNodes, unvisitedNodes, grid);
            visitedNodes.add(currentNode[0] + "|" + currentNode[1]);
        }
        return res;
    }
}
