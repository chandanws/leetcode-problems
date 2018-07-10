// Problem link: https://leetcode.com/problems/number-of-matching-subsequences/description/
// Status: Accepted

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        HashMap<Character, ArrayList<Integer>> hm = new HashMap<Character, ArrayList<Integer>>();
        for(int i = 0; i < S.length(); i++) {
            if(!hm.containsKey(S.charAt(i))) hm.put(S.charAt(i), new ArrayList<Integer>());
            hm.get(S.charAt(i)).add(i);
        }
        int ans = 0;
        for(int i = 0; i < words.length; i++) {
            int lastIndex = -1, j = 0;
            while(j < words[i].length() && hm.containsKey(words[i].charAt(j))) {
                int nextAvailableIndex;
                if(lastIndex == -1) nextAvailableIndex = hm.get(words[i].charAt(j)).get(0);
                else {
                    nextAvailableIndex = Collections.binarySearch(hm.get(words[i].charAt(j)), lastIndex + 1);
                    if(nextAvailableIndex < 0) {
                        nextAvailableIndex = Math.abs(nextAvailableIndex) - 1;
                        if(nextAvailableIndex >= hm.get(words[i].charAt(j)).size()) break;
                    }
                    nextAvailableIndex = hm.get(words[i].charAt(j)).get(nextAvailableIndex);
                }
                lastIndex = nextAvailableIndex;
                j++;
            }
            if(j == words[i].length()) ans++;
        }
        return ans;
    }
}
