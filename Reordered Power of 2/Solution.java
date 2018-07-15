// Problem link: https://leetcode.com/problems/reordered-power-of-2/description/
// Status: Accepted

class Solution {
    private boolean checkIdentical(HashMap<Integer, Integer> hm1, HashMap<Integer, Integer> hm2) {
        if(hm1.size() != hm2.size()) return false;
        for(Map.Entry<Integer, Integer> entry : hm1.entrySet()) {
            if(!hm2.containsKey(entry.getKey())) return false;
            if(hm1.get(entry.getKey()) != hm2.get(entry.getKey())) return false;
        }
        return true;
    }
    public boolean reorderedPowerOf2(int N) {
        if(N == 1) return true;
        int numOfDigs = Integer.toString(N).length();
        long res = 1L;
        List<HashMap<Integer, Integer>> l = new ArrayList<>();
        int j = 1;
        for(int i = 0; i < 31; i++) {
            res *= 2;
            String resToStr = Long.toString(res);
            if(resToStr.length() == numOfDigs) {
                for(int k = 0; k < resToStr.length(); k++) {
                    if(l.size() < j) l.add(new HashMap<Integer, Integer>());
                    int v = Character.getNumericValue(resToStr.charAt(k));
                    if(resToStr.length() == 10 && j == 2 && k + 1 == resToStr.length()) v--;
                    l.get(j - 1).put(v, l.get(j - 1).getOrDefault(v, 0) + 1);
                }
                j++;
            } else if(resToStr.length() > numOfDigs) break;
        }
        String originalNum = Integer.toString(N);
        HashMap<Integer, Integer> orgNumHm = new HashMap<Integer, Integer>();
        for(int i = 0; i < originalNum.length(); i++) {
            int v = Character.getNumericValue(originalNum.charAt(i));
            orgNumHm.put(v, orgNumHm.getOrDefault(v, 0) + 1);
        }
        for(int i = 0; i < l.size(); i++) {
            if(checkIdentical(orgNumHm, l.get(i))) return true;
        }
        return false;
    }
}
