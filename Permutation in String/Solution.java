// Problem link: https://leetcode.com/problems/permutation-in-string/description/
// Status: Accepted

class Solution {
    private boolean comparePermutationString(int [] str1, int [] str2) {
        for(int i = 0; i < 26; i++) {
            if(str1[i] != str2[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if(n > m) return false;
        else if(n == 0) return true;
        int [] str1 = new int[26];
        int [] str2 = new int[26];
        for(int i = 0; i < n; i++) str1[s1.charAt(i) - 'a']++;
        for(int i = 0; i < n - 1; i++) str2[s2.charAt(i) - 'a']++;
        int j = 0;
        while((j + n - 1) < m) {
            str2[s2.charAt(j + n - 1) - 'a']++;
            if(comparePermutationString(str1, str2)) return true;
            str2[s2.charAt(j++) - 'a']--;
        }
        return false;
    }
}
