// Problem link: https://leetcode.com/problems/is-subsequence/description/
// Status: Accepted

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0, n = s.length(), m = t.length();
        while(n > 0 && j < m) {
            if(s.charAt(i) == t.charAt(j++)) {
                i++;
                if(i == n) return true;
            }
        }
        return n == 0 ? true : false;
    }
    public boolean isSubsequenceBillionsOfSList(String s, String t) {
        HashMap<Character, List<Integer>> hm = new HashMap<Character, List<Integer>>();
        for(int i = 0; i < t.length(); i++) {
            if(!hm.containsKey(t.charAt(i))) hm.put(t.charAt(i), new ArrayList<Integer>());
            hm.get(t.charAt(i)).add(i);
        }
        int start = -1;
        for(char c : s.toCharArray()) {
            if(!hm.containsKey(c)) return false;
            if(start == -1) start = hm.get(c).get(0);
            else {
                int next = Collections.binarySearch(hm.get(c), start + 1);
                if(next < 0) next = Math.abs(next) - 1;
                if(next >= hm.get(c).size() || hm.get(c).get(next) < start) return false;
                start = hm.get(c).get(next);
            }
        }
        return true;
    }
}
