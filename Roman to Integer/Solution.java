// Problem link: https://leetcode.com/problems/roman-to-integer/description
// Status: Accepted

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i + 1 < s.length() && hm.get(s.charAt(i)) < hm.get(s.charAt(i + 1))) {
                sum += (hm.get(s.charAt(i + 1)) - hm.get(s.charAt(i)));
                i++;
            } else {
                sum += hm.get(s.charAt(i));
            }
        }
        return sum;
    }
}
