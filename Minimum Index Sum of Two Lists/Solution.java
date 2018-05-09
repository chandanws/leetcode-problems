// Problem link: https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/
// Status: Accepted

import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        int len = list1.length;
        for(int i = 0; i < len; i++) ht.put(list1[i], i);
        int minSum = Integer.MAX_VALUE;
        ArrayList<String> l = new ArrayList<String>();
        len = list2.length;
        for(int i = 0; i < len; i++) {
            if(ht.containsKey(list2[i])) {
                int indexSum = ht.get(list2[i]) + i;
                if(indexSum <= minSum) {
                    if(indexSum < minSum) {
                        minSum = indexSum;
                        l.clear();
                    }
                    l.add(list2[i]);
                }
            }
        }
        len = l.size();
        String [] answers = new String[len];
        for(int i = 0; i < len; i++) answers[i] = l.get(i);
        return answers;
    }
}
