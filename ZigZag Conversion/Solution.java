  
// Problem link: https://leetcode.com/problems/zigzag-conversion/description/
// Status: Accepted

class Solution {
    private void traverseZigZag(char [][] arr, String s, int i, int j, int dir) {
        if(s.length() == 0) return;
        arr[i][j] = s.charAt(0);
        if(i + 1 == arr.length || dir == 1 && i != 0) {
            traverseZigZag(arr, s.substring(1), i - 1, j + 1, 1);
        } else if(i == 0 || dir == 0) {
            traverseZigZag(arr, s.substring(1), i + 1, j, 0);
        }
    }
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        char [][] charArr = new char[numRows][s.length()];
        // 0:down 1:diagonal
        traverseZigZag(charArr, s, 0, 0, 0);
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < s.length(); j++) {
                if(charArr[i][j] != 0) ans.append(charArr[i][j]);
            }
        }
        return ans.toString();
    }
}
