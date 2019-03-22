// Problem link: https://leetcode.com/problems/find-common-characters/description/
// Status: Accepted

class Solution {
    public List<String> commonChars(String[] A) {
        List<HashMap<Character, List<Integer>>> map = new ArrayList<>();
        int k = 0;
        for(String word : A) {
            int i = 0;
            map.add(new HashMap<>());
            for(char c : word.toCharArray()) {
                if(!map.get(k).containsKey(c)) map.get(k).put(c, new ArrayList<>());
                map.get(k).get(c).add(i++);
            }
            k++;
        }
        List<String> ans = new ArrayList<>();
        for(char c : A[0].toCharArray()) {
            boolean in = true;
            for(int i = 1; i < A.length && in; i++) {
                if(map.get(i).containsKey(c) && map.get(i).get(c).size() > 0) {
                    map.get(i).get(c).remove(0);
                } else in = false;
            }
            if(in) ans.add(c + "");
        }
        return ans;
    }
}
