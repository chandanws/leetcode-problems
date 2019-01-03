// Problem link: https://leetcode.com/problems/vowel-spellchecker/description/
// Status: Accepted

class Solution {
    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        word = word.toLowerCase();
        for(char c : word.toCharArray()) {
            if(isVowel(c)) sb.append("*");
            else sb.append(c);
        }
        return sb.toString();
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> seen = new HashSet<String>();
        HashMap<String, List<String>> capWords = new HashMap<String, List<String>>();
        HashMap<String, List<String>> vowelWords = new HashMap<String, List<String>>();
        for(String word : wordlist) {
            seen.add(word);
            if(capWords.containsKey(word.toLowerCase())) capWords.get(word.toLowerCase()).add(word);
            else capWords.put(word.toLowerCase(), new ArrayList<String>(Arrays.asList(word)));
            String w = devowel(word);
            if(vowelWords.containsKey(w)) vowelWords.get(w).add(word);
            else vowelWords.put(w, new ArrayList<String>(Arrays.asList(word)));
        }
        String [] ans = new String[queries.length];
        for(int i = 0; i < queries.length; i++) {
            String w = devowel(queries[i]);
            if(seen.contains(queries[i])) ans[i] = queries[i];
            else if(capWords.containsKey(queries[i].toLowerCase())) ans[i] = capWords.get(queries[i].toLowerCase()).get(0);
            else if(vowelWords.containsKey(w)) ans[i] = vowelWords.get(w).get(0);
            else ans[i] = "";
        }
        return ans;
    }
}
