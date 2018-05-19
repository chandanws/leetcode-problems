// Problem link: https://leetcode.com/problems/judge-route-circle/description/
// Status: Accepted

class Solution {
    public boolean judgeCircle(String moves) {
        int i = 0, j = 0;
        for(char c : moves.toCharArray()) {
            switch(c) {
                case 'U':
                    i--;
                    break;
                case 'D':
                    i++;
                    break;
                case 'L':
                    j--;
                    break;
                case 'R':
                    j++;
                    break;
            }
        }
        return i == 0 && j == 0;
    }
}
