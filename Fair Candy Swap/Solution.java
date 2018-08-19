// Problem link: https://leetcode.com/problems/fair-candy-swap/description/
// Status: Accepted

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int sum1 = 0, sum2 = 0;
        for(int a : A) {
            sum1 += a;
            hs.add(a);
        }
        for(int b : B) sum2 += b;
        int supposeSum = (sum1 + sum2) / 2;
        int [] res = new int[2];
        for(int b : B) {
            if(hs.contains(supposeSum - (sum2 - b))) {
                res[0] = supposeSum - (sum2 - b);
                res[1] = b;
                break;
            }
        }
        return res;
    }
}
