// Problem link: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
// Status: Accepted

class Solution {
    public String findLongestWord(String s, List<String> d) {
        int sLen = s.length(), maxWordLen = Integer.MIN_VALUE;
        ArrayList<String> l = new ArrayList<String>();
        for(String word : d) {
            int i = 0, j = 0, wordLen = word.length();
            while(i < sLen && j < wordLen && sLen >= wordLen) {
                if(s.charAt(i) == word.charAt(j)) j++;
                i++;
            }
            if(j == wordLen && j >= maxWordLen) {
                if(j > maxWordLen) {
                    maxWordLen = j;
                    l.clear();
                }
                l.add(word);
            }
        }
        int lLen = l.size();
        if(lLen == 0) return "";
        String [] res = new String[lLen];
        for(int k = 0; k < lLen; k++) res[k] = l.get(k);
        Arrays.sort(res);
        return res[0];
    }
}
