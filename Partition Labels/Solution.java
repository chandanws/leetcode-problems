// Problem link: https://leetcode.com/problems/partition-labels/description/
// Status: Accepted

class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int i = 0;
        for(char c : S.toCharArray()) hm.put(c, i++);
        List<Integer> res = new ArrayList<Integer>();
        i = 0;
        int divider = 0, start = 0;
        for(char c : S.toCharArray()) {
            if(hm.get(c) > divider) divider = hm.get(c);
            if(i == divider) {
                res.add(i - start + 1);
                divider++;
                start = divider;
            }
            i++;
        }
        return res;
    }
}
