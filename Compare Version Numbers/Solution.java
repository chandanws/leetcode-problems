// Problem link: https://leetcode.com/problems/compare-version-numbers/description/
// Status: Accepted

class Solution {
    public int compareVersion(String version1, String version2) {
        String [] v1 = version1.split("\\.");
        String [] v2 = version2.split("\\.");
        int i1 = 0, i2 = 0;
        while(i1 < v1.length || i2 < v2.length) {
            int currentV1 = 0, currentV2 = 0;
            if(i1 < v1.length) currentV1 = (int) Integer.parseInt(v1[i1++]);
            if(i2 < v2.length) currentV2 = (int) Integer.parseInt(v2[i2++]);
            if(currentV2 > currentV1) return -1;
            else if(currentV1 > currentV2) return 1;
        }
        return 0;
    }
}
