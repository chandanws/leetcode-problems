// Problem link: https://leetcode.com/problems/repeated-dna-sequences/description/
// Status: Accepted

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<String>(), added = new HashSet<String>();
        for(int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            if(!seen.contains(str)) seen.add(str);
            else added.add(str);
        }
        return new ArrayList<String>(added);
    }
}
