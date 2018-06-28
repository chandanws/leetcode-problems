// Problem link: https://leetcode.com/problems/custom-sort-string/description/
// Status: Accepted

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(char c : T.toCharArray()) hm.put(c, hm.getOrDefault(c, 0) + 1);
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()) {
            if(hm.containsKey(c)) {
                int count = hm.get(c);
                for(int i = 0; i < count; i++) sb.append(c);
                hm.remove(c);
            }
        }
        for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) sb.append(entry.getKey());
        }
        return sb.toString();
    }
}
