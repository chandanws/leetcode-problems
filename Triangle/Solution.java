// Problem link: https://leetcode.com/problems/triangle/description/
// Status: Accepted

class Solution {
    private int [][] cache;
    private int dp(List<List<Integer>> triangle, int i, int j) {
        if(i >= triangle.size()) return -1;
        if(i < triangle.size() - 1 && cache[i][0] != -1 && j == cache[i][0]) return cache[i][1];
        int left = dp(triangle, i + 1, j);
        int right = dp(triangle, i + 1, j + 1);
        if(left == -1 && right == -1) return triangle.get(i).get(j);
        cache[i][0] = j;
        cache[i][1] = Math.min(left + triangle.get(i).get(j), right + triangle.get(i).get(j));
        return cache[i][1];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        cache = new int[triangle.size() - 1][2];
        for(int i = 0; i < triangle.size() - 1; i++) cache[i][0] = -1;
        return dp(triangle, 0, 0);
    }
}
