// Problem link: https://leetcode.com/problems/perfect-number/description/
// Status: Accepted

class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num % 2 != 0 || num == 0) return false;
        int upTo = num / 2 + 1;
        ArrayList<Integer> divisibleNum = new ArrayList<Integer>();
        for(int i = 1; i < upTo; i++) {
            int res = num / i;
            if(res * i == num) divisibleNum.add(i);
        }
        return divisibleNum.stream().mapToInt(Integer::intValue).sum() == num;
    }
}
