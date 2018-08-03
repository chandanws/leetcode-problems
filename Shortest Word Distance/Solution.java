// Problem link: https://leetcode.com/problems/shortest-word-distance/description/
// Status: Accepted

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int shortestDist = Integer.MAX_VALUE, lastSeenWord1 = -1, lastSeenWord2 = -1;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) lastSeenWord1 = i;
            else if(words[i].equals(word2)) lastSeenWord2 = i;
            if(lastSeenWord1 > -1 && lastSeenWord2 > -1) shortestDist = Math.min(shortestDist, Math.abs(lastSeenWord1 - lastSeenWord2));
        }
        return shortestDist;
    }
}
