// Problem link: https://leetcode.com/problems/add-two-numbers-ii/description/
// Status: Accepted

import java.util.*;
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] re = new int[2];
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for(int i = 0; i < numbers.length; i++) {
            if(ht.containsKey(target - numbers[i])) {
                re[0] = ht.get(target - numbers[i]) + 1;
                re[1] = i + 1;
                break;
            }
            ht.put(numbers[i], i);
        }
        return re;
    }
}
