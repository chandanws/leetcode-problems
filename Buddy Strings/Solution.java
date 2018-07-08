// Problem link: https://leetcode.com/problems/buddy-strings/description/
// Status: Accepted

class Solution {
    public boolean buddyStrings(String A, String B) {
        int m = A.length(), n = B.length();
        if(m != n || (m == 0 && n == 0)) return false;
        char [] AChar = A.toCharArray();
        if(A.equals(B)) {
            int [] duplicates = new int[26];
            for(char c : AChar) {
                if(duplicates[c - 'a'] == 1) return true;
                duplicates[c - 'a'] = 1;
            }
            return false;
        }
        int i = 0, j = m - 1;
        while(i < m - 1 && AChar[i] == B.charAt(i)) i++;
        while(j > 0 && AChar[j] == B.charAt(j)) j--;
        if(i == j) return false;
        char c = AChar[i];
        AChar[i] = AChar[j];
        AChar[j] = c;
        return String.valueOf(AChar).equals(B);
    }
}
