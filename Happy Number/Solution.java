// Problem link: https://leetcode.com/problems/happy-number/description/
// Status: Accepted

class Solution {
    public boolean isHappyWithHashSet(int n) {
        if(n < 0) return false;
        int num = n;
        HashSet<Integer> hs = new HashSet<Integer>();
        while(true) {
            int sum = 0;
            while(num != 0) {
                int remainder = num % 10;
                sum += Math.pow(remainder, 2);
                num -= remainder;
                num /= 10;
            }
            if(sum == 1) return true;
            if(hs.contains(sum)) break;
            hs.add(sum);
            num = sum;
        }
        return false;
    }
    public boolean isHappyWithoutHashSet(int n) {
        if(n < 0) return false;
        int num = n;
        while(num != 1 && num != 7) {
            int sum = 0;
            while(num != 0) {
                int remainder = num % 10;
                sum += remainder * remainder;
                num /= 10;
            }
            num = sum;
            if(num < 10 && num != 1 && num != 7) break; // ensure no cycle
        }
        return num == 1 || num == 7;
    }
}
