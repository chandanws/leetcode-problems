// Problem link: https://leetcode.com/problems/self-dividing-numbers/description/
// Status: Accepted

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = left; i < right + 1; i++) {
            boolean isSelfDiv = true;
            for(char c : Integer.toString(i).toCharArray()) {
                int modValue = Character.getNumericValue(c);
                if(modValue == 0 || i % modValue != 0) {
                    isSelfDiv = false;
                    break;
                }
            }
            if(isSelfDiv) res.add(i);
        }
        return res;
    }
}
