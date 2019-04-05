// Problem link: https://leetcode.com/problems/number-of-enclaves/description/
// Status: Accepted

class Solution {
    public void dfs(int[][] A, int i, int j, HashSet<String> visited) {
        if(i < 0 || j < 0 || i == A.length || j == A[0].length || A[i][j] == 0 || visited.contains(i + "," + j)) return;
        visited.add(i + "," + j);
        dfs(A, i - 1, j, visited);
        dfs(A, i + 1, j, visited);
        dfs(A, i, j - 1, visited);
        dfs(A, i, j + 1, visited);
    }
    public int numEnclaves(int[][] A) {
        HashSet<String> visited = new HashSet<String>();
        for(int i = 0; i < A.length; i++) dfs(A, i, 0, visited);
        for(int i = 0; i < A.length; i++) dfs(A, i, A[0].length - 1, visited);
        for(int i = 1; i < A[0].length - 1; i++) dfs(A, 0, i, visited);
        for(int i = 1; i < A[0].length - 1; i++) dfs(A, A.length - 1, i, visited);
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 1 && !visited.contains(i + "," + j)) ans++;
            }
        }
        return ans;
    }
}
