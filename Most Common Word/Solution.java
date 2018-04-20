// Problem link: https://leetcode.com/problems/most-common-word/description/
// Status: Accepted

import java.util.*;

class Solution {
    private String removePunctuationSymbols(String paragraph) {
        paragraph = paragraph.replace("!", "");
        paragraph = paragraph.replace("?", "");
        paragraph = paragraph.replace("'", "");
        paragraph = paragraph.replace(",", "");
        paragraph = paragraph.replace(";", "");
        paragraph = paragraph.replace(".", "");
        return paragraph;
    }
    private String removeBannedWords(String paragraph, String [] banned) {
        HashSet<String> hs = new HashSet<>();
        for(String bannedWord : banned) {
            hs.add(bannedWord);
        }
        StringBuilder res = new StringBuilder();
        String [] words = paragraph.split(" ");
        for(String word : words) {
            if(!hs.contains(word)) {
                res.append(word);
                res.append(" ");
            }
        }
        return res.toString().trim();
    }
    private String findMostOccurrences(String paragraph) {
        Hashtable<String, Integer> ht = new Hashtable<>();
        Integer maxOccur = 0;
        String maxWord = "";
        String [] words = paragraph.split(" ");
        for(String eachWord : words) {
            if(ht.containsKey(eachWord)) {
                ht.put(eachWord, ht.get(eachWord) + 1);
            } else {
                ht.put(eachWord, 1);
            }
            if(ht.get(eachWord) > maxOccur) { 
                maxOccur = ht.get(eachWord);
                maxWord = eachWord;
            }
        }
        return maxWord;
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = removePunctuationSymbols(paragraph);
        paragraph = paragraph.toLowerCase();
        paragraph = removeBannedWords(paragraph.replaceAll("\\s{2,}", " "), banned);
        return findMostOccurrences(paragraph);
    }
}
