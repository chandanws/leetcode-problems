// Problem link: https://leetcode.com/problems/unique-morse-code-words/description/
// Status: Accepted

class Solution {
    private String [] morseLookedUpTable = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        int numberOfWords = words.length;
        HashSet<String> hs = new HashSet<String>();
        for(int i = 0; i < numberOfWords; i++) {
            int wordLen = words[i].length();
            StringBuilder wordToMorse = new StringBuilder();
            for(int j = 0; j < wordLen; j++) {
                wordToMorse.append(morseLookedUpTable[words[i].charAt(j) - 'a']);
            }
            hs.add(wordToMorse.toString());
        }
        return hs.size();
    }
}
