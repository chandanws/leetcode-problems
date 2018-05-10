// Problem link: https://leetcode.com/problems/longest-word-in-dictionary/description/
// Status: Accepted

class Solution {
    public String longestWord(String [] words) {
        Arrays.sort(words);
        HashSet<String> hs = new HashSet<String>();
        for(String word : words) hs.add(word);
        int wordsLen = words.length, currentMaxLen = 0;
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        for(int i = wordsLen - 1; i >= 0; i--) {
            int wordLen = words[i].length(), j = 1;
            if(wordLen < currentMaxLen) continue;
            while(j < wordLen) {
                if(!hs.contains(words[i].substring(0, j))) break;
                j++;
            }
            if(j == wordLen) {
                possibleAnswers.add(words[i]);
                currentMaxLen = wordLen;
            }
        }
        int possibleAnswersLen = possibleAnswers.size();
        if(possibleAnswersLen == 0) return "";
        String [] answers = new String[possibleAnswersLen];
        for(int i = 0; i < possibleAnswersLen; i++) answers[i] = possibleAnswers.get(i);
        Arrays.sort(answers);
        return answers[0];
    }
}
