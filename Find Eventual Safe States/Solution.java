// Problem link: https://leetcode.com/problems/find-eventual-safe-states/description/
// Status: Accepted

class Solution {
    public boolean dfs(int i, int[][] graph, int[] color) {
        if(color[i] > 0) return color[i] == 2;
        color[i] = 1;
        for(int nodeIndex : graph[i]) {
            if(color[nodeIndex] == 2) continue;
            if(color[nodeIndex] == 1 || !dfs(nodeIndex, graph, color)) return false;
        }
        color[i] = 2;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length; i++) if(dfs(i, graph, color)) ans.add(i);
        return ans;
    }
}
