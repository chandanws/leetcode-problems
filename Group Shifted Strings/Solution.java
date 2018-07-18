// Problem link: https://leetcode.com/problems/group-shifted-strings/description/
// Status: Accepted

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        for(String word : strings) {
            String hash = "0,";
            char [] wordInChar = word.toCharArray();
            if(wordInChar.length > 0) {
                int firstWord = (wordInChar[0] - 'a');
                for(int i = 1; i < wordInChar.length; i++) {
                    hash += Math.floorMod(wordInChar[i] - 'a' - firstWord, 26);
                    if(i + 1 < wordInChar.length) hash += ",";
                }
            } else {
                hash = "";
            }
            if(!hm.containsKey(hash)) hm.put(hash, new ArrayList<>());
            hm.get(hash).add(word);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : hm.entrySet()) ans.add(entry.getValue());
        return ans;
    }
}
