// Problem link: https://leetcode.com/problems/minimum-genetic-mutation/description/
// Status: Accepted

import java.lang.StringBuilder;

class Solution {
    private HashSet<String> visited;
    private int helper(StringBuilder start, StringBuilder end, String[] bank, int level) {
        if(start.toString().equals(end.toString())) return level;
        int min = Integer.MAX_VALUE;
        for(String word : bank) {
            if(visited.contains(word)) continue;
            int diff = 0;
            for(int i = 0; i < 8; i++) {
                if(word.charAt(i) != start.charAt(i)) diff++;
            }
            if(diff == 1 && !visited.contains(word)) {
                visited.add(word);
                min = Math.min(min, helper(new StringBuilder(word), end, bank, level + 1));
                visited.remove(word);
            }
        }
        return min;
    }
    public int minMutation(String start, String end, String[] bank) {
        visited = new HashSet<String>();
        int min = helper(new StringBuilder(start), new StringBuilder(end), bank, 0);
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
}
