// Problem link: https://leetcode.com/problems/factor-combinations/description/
// Status: Accepted

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> currentList = new ArrayList<>();
    private void computeFactors(int n, int lower) {
        if(n == 1) return;
        int upper = (int) Math.sqrt(n);
        for(int i = lower; i <= upper; i++) {
            if(n % i == 0) {
                currentList.add(i);
                currentList.add(n / i);
                res.add(new ArrayList<>(currentList));
                currentList.remove(currentList.size() - 1);
                computeFactors(n / i, i);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
    public List<List<Integer>> getFactors(int n) {
        computeFactors(n, 2);
        return res;
    }
}
