// Problem link: https://leetcode.com/problems/top-k-frequent-words/description/
// Status: Accepted

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        int freq = Integer.MIN_VALUE;
        for(String word : words) {
            int occurrence = hm.getOrDefault(word, 0) + 1; 
            hm.put(word, occurrence);
            if(occurrence > freq) freq = occurrence;
        }
        ArrayList<ArrayList<String>> l = new ArrayList<>();
        for(int i = 0; i < freq; i++) l.add(new ArrayList<String>());
        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
            l.get(entry.getValue() - 1).add(entry.getKey());
        }
        ArrayList<String> res = new ArrayList<String>();
        for(int i = freq - 1; i >= 0; i--) {
            int len = l.get(i).size();
            String [] listOfWords = new String[len];
            for(int j = 0; j < len; j++) listOfWords[j] = l.get(i).get(j);
            Arrays.sort(listOfWords);
            for(int j = 0; j < len && k > 0; j++, k--) res.add(listOfWords[j]);
        }
        return res;
    }
}
