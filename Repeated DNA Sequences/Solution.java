// Problem link: https://leetcode.com/problems/repeated-dna-sequences/description/
// Status: Accepted

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> res = new ArrayList<String>();
        if(n < 10) return res;
        int left = 0, right = 9;
        HashSet<String> hs = new HashSet<String>();
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i = 0; i < n - 9; i++) {
            String str = s.substring(left + i, right + i + 1);
            if(!hm.containsKey(str)) hm.put(str, 1);
            else hs.add(str);
        }
        for(String nextStr : hs) res.add(nextStr);
        return res;
    }
}
