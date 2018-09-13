// Problem link: https://leetcode.com/problems/letter-case-permutation/description/
// Status: Accepted

class Solution {
    private void helper(StringBuilder sb, int i, List<String> res) {
        if(i == sb.length()) {
            res.add(sb.toString());
            return;
        }
        helper(sb, i + 1, res);
        if(sb.charAt(i) >= 'a' && sb.charAt(i) <= 'z') {
            sb.setCharAt(i, (char) (sb.charAt(i) - 'a' + 'A'));
            helper(sb, i + 1, res);
        } else if(sb.charAt(i) >= 'A' && sb.charAt(i) <= 'Z') {
            sb.setCharAt(i, (char) (sb.charAt(i) - 'A' + 'a'));
            helper(sb, i + 1, res);
        }
    }
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        helper(new StringBuilder(S), 0, res);
        return res;
    }
}
