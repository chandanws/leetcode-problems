// Problem link: https://leetcode.com/problems/brick-wall/description/
// Status: Accepted

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for(int j = 0; j < wall.get(i).size(); j++) {
                sum += wall.get(i).get(j);
                hm.put(sum, hm.getOrDefault(sum, 0) + 1);
            }
        }
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>(hm);
        int k = -1, leastBricks = wall.size();
        for(Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            k++;
            if(k == tm.size() - 1) continue;
            int bricks = wall.size() - entry.getValue();
            if(leastBricks > bricks) leastBricks = bricks;
        }
        return leastBricks;
    }
}
