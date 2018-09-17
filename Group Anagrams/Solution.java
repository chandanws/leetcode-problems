// Problem link: https://leetcode.com/problems/group-anagrams/description/
// Status: Accepted

class Solution {
    private String getSortedWord(String word) {
        int [] alphabet = new int[26];
        for(char c : word.toCharArray()) alphabet[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < alphabet[i]; j++) sb.append((char) (i + 'a'));
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String [] strs) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        List<List<String>> res = new ArrayList<>();
        int i = 0;
        for(String word : strs) {
            String sortedWord = getSortedWord(word);
            if(hm.containsKey(sortedWord)) res.get(hm.get(sortedWord)).add(word);
            else {
                res.add(new ArrayList<>(Arrays.asList(word)));
                hm.put(sortedWord, i++);
            }
        }
        return res;
    }
}
