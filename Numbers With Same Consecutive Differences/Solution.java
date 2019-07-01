// Problem link: https://leetcode.com/problems/numbers-with-same-consecutive-differences/description/
// Status: Accepted

class Solution {
    public void findNextValidNumber(List<Integer> res, StringBuilder sb, int N, int K) {
        if(sb.length() == N) {
            res.add(Integer.parseInt(sb.toString()));
        } else {
            int curr = sb.charAt(sb.length() - 1) - '0';
            if(curr + K <= 9) {
                findNextValidNumber(res, new StringBuilder(sb.toString()).append(Integer.toString(curr + K)), N, K);
            }
            if(curr - K >= 0 && K != 0) {
                findNextValidNumber(res, new StringBuilder(sb.toString()).append(Integer.toString(curr - K)), N, K);
            }
        }
    }
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> res = new ArrayList<Integer>();
        if(N == 1) res.add(0);
        for(int i = 1; i < 10; i++) {
            findNextValidNumber(res, new StringBuilder(Integer.toString(i)), N, K);
        }
        int [] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
