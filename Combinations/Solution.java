// Problem link: https://leetcode.com/problems/combinations/description/
// Status: Accepted

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 1, j = i + k - 1, s = i;
        List<Integer> currentList = new ArrayList<>();
        while(s < i + k - 1) currentList.add(s++);
        currentList.add(j);
        res.add(new ArrayList<>(currentList));
        while(true) {
            int lastNum = currentList.get(currentList.size() - 1);
            if(lastNum + 1 <= n) {
                currentList.remove(currentList.size() - 1);
                currentList.add(++lastNum);
            } else {
                if(currentList.size() > 1) {
                    if(currentList.get(currentList.size() - 1) - currentList.get(currentList.size() - 2) == 1) {
                        int index = currentList.size() - 2, p = currentList.size() - 1;
                        while(index > 0 && currentList.get(index) - currentList.get(index - 1) == 1) index--;
                        while(p >= index) currentList.remove(p--);
                        if(currentList.size() == 0) break;
                    } else currentList.remove(currentList.size() - 1);
                }
                lastNum = currentList.get(currentList.size() - 1);
                currentList.remove(currentList.size() - 1);
                while(currentList.size() < k) currentList.add(++lastNum);
            }
            if(currentList.get(currentList.size() - 1) > n) break;
            res.add(new ArrayList<>(currentList));
        }
        return res;
    }
}
