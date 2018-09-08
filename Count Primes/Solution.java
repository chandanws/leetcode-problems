// Problem link: https://leetcode.com/problems/count-primes/description/
// Status: Accepted

class Solution {
    public int countPrimes(int n) {
        if(n < 3) return 0;
        boolean [] visited = new boolean[n];
        for(int i = 2; i * i < n; i++) {
            if(visited[i]) continue;
            for(int j = i; i * j < n; j++) {
                visited[i * j] = true;
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(!visited[i]) count++;
        }
        return count;
    }
}
