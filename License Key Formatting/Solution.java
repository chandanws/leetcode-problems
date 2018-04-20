// Problem link: https://leetcode.com/problems/license-key-formatting/description/
// Status: Accepted

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "").toUpperCase();
        StringBuilder str = new StringBuilder(S);
        for(int i = S.length() - K; i > 0; i -= K) str.insert(i, "-");
        return str.toString();
    }
}
