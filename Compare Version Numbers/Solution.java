// Problem link: https://leetcode.com/problems/compare-version-numbers/description/
// Status: Accepted

class Solution {
    public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        for(int i = 0; i < v1.length || i < v2.length; i++) {
            int version1Num = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int version2Num = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if(version1Num > version2Num) return 1;
            else if(version1Num < version2Num) return -1;
        }
        return 0;
    }
}
