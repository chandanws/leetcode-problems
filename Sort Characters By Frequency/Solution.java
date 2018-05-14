// Problem link: https://leetcode.com/problems/sort-characters-by-frequency/description/
// Status: Accepted

class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(char c : s.toCharArray()) hm.put(c, hm.getOrDefault(c, 0) + 1);
        List<String> [] l = new List[len + 1];
        for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
            int freq = entry.getValue();
            StringBuilder str = new StringBuilder();
            for(int j = 0; j < freq; j++) str.append(entry.getKey());
            if(l[freq] == null) l[freq] = new ArrayList<>();
            l[freq].add(str.toString());
        }
        StringBuilder res = new StringBuilder();
        for(int freq = len; freq > 0; freq--) {
            if(l[freq] == null) continue;
            int numberOfCharacters = l[freq].size();
            for(int j = 0; j < numberOfCharacters; j++) res.append(l[freq].get(j));
        }
        return res.toString();
    }
}
