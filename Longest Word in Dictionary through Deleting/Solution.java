// Problem link: https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
// Status: Accepted

class Solution {
    public String findLongestWord(String s, List<String> d) {
        int sLen = s.length();
        String lastMatchedWord = "";
        for(String word : d) {
            int i = 0, j = 0, strLen = word.length();
            while(i < sLen && j < strLen) {
                if(s.charAt(i) == word.charAt(j)) j++;
                i++;
            }
            if(j == strLen) {
                if(j > lastMatchedWord.length()) {
                    lastMatchedWord = word;
                } else if(j == lastMatchedWord.length()) {
                    String [] strs = new String[]{lastMatchedWord, word};
                    Arrays.sort(strs);
                    lastMatchedWord = strs[0];
                }
            }
        }
        return lastMatchedWord;
    }
}
