// Problem link: https://leetcode.com/problems/consecutive-numbers-sum/description/
// Status: Accepted

class Solution {
    public int consecutiveNumbersSum(int N) {
        int num = (int) Math.pow(N*2, 0.5);
        int sum = (1 + num) * num / 2;
        int count = 0;
        for(int i = num; i > 0; i--) {
            if(sum <= N && (N - sum) % i == 0) count++;
            sum -= i;
        }
        return count;
    }
}
