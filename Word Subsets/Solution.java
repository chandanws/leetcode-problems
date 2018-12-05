// Problem link: https://leetcode.com/problems/word-subsets/
// Status: Accepted

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<String>();
        int [] b = new int[26];
        for(int i = 0; i < B.length; i++) {
            int [] arr = new int[26];
            for(char c : B[i].toCharArray()) arr[c - 'a']++;
            for(int j = 0; j < 26; j++) b[j] = Math.max(b[j], arr[j]);
        }
        for(int i = 0; i < A.length; i++) {
            int [] a = new int[26];
            for(char c : A[i].toCharArray()) a[c - 'a']++;
            boolean ans = true;
            for(int j = 0; j < 26 && ans; j++) if(a[j] < b[j]) ans = false;
            if(ans) res.add(A[i]);
        }
        return res;
    }
}
