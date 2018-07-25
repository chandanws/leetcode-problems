// Problem link: https://leetcode.com/problems/lonely-pixel-i/description/
// Status: Accepted

class Solution {
    public int findLonelyPixel(char[][] picture) {
        int n = picture.length, m = picture[0].length;
        int [] rows = new int[n];
        int [] cols = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) if(picture[i][j] == 'B') rows[i]++;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) if(picture[j][i] == 'B') cols[i]++;
        }
        int lonelyPixel = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(picture[i][j] == 'B' && rows[i] == 1 && cols[j] == 1) lonelyPixel++;
            }
        }
        return lonelyPixel;
    }
}
