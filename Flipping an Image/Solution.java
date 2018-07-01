// Problem link: https://leetcode.com/problems/flipping-an-image/description/
// Status: Accepted

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for(int i = 0; i < n; i++) {
            int a = 0, b = n - 1;
            while(a < b) {
                int num = A[i][a];
                A[i][a] = A[i][b] ^ 1;
                A[i][b] = num ^ 1;
                a++;
                b--;
            }
            if(n % 2 != 0) A[i][(int) n / 2] ^= 1;
        }
        return A;
    }
}
