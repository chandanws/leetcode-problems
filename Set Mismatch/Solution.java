// Problem link: https://leetcode.com/problems/set-mismatch/description/
// Status: Accepted

import java.util.*;

class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int num : nums) hm.put(num, hm.getOrDefault(num, 0) + 1);
        int len = nums.length;
        int [] res = new int[2];
        for(int i = 1; i < len + 1 && (res[0] == 0 || res[1] == 0); i++) {
            if(!hm.containsKey(i)) res[1] = i;
            else if(hm.get(i) == 2) res[0] = i;
        }
        return res;
    }
}
