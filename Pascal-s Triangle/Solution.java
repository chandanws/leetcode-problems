// Problem link: https://leetcode.com/problems/pascals-triangle/description/
// Status: Accepted

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i < numRows + 1; i++) {
            List<Integer> innerList = new ArrayList<>();
            int k = 0;
            for(int j = 0; j < i; j++) {
                if(j == 0 || j == i - 1) {
                    innerList.add(1);
                    continue;
                }
                List<Integer> upperInnerList = res.get(i - 2);
                innerList.add(upperInnerList.get(k) + upperInnerList.get(k + 1));
                k++;
                
            }
            res.add(innerList);
        }
        return res;
    }
}
