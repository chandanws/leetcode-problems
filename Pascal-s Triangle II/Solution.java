// Problem link: https://leetcode.com/problems/pascals-triangle-ii/description/
// Status: Accepted

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(Arrays.asList(1));
        for(int i = 1; i < rowIndex + 1; i++) {
            res.add(1);
            for(int j = 1; j < i; j++) {
                res.add(res.get(0) + res.get(1));
                res.remove(0);
            }
            res.add(1);
            res.remove(0);
        }
        return res;
    }
}
