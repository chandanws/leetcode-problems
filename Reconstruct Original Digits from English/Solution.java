// Problem link: https://leetcode.com/problems/reconstruct-original-digits-from-english/description/
// Status: Accepted

class Solution {
    public String originalDigits(String s) {
        int [] alpha = new int[26];
        for(char c : s.toCharArray()) alpha[c - 'a']++;
        LinkedHashMap<Character, Integer> uniChar = new LinkedHashMap<Character, Integer>();
        uniChar.put('z', 0);
        uniChar.put('g', 8);
        uniChar.put('w', 2);
        uniChar.put('u', 4);
        uniChar.put('o', 1);
        uniChar.put('f', 5);
        uniChar.put('h', 3);
        uniChar.put('v', 7);
        uniChar.put('n', 9);
        uniChar.put('s', 6);
        String [] dict = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int [] ans = new int[10];
        for(Map.Entry<Character, Integer> entry : uniChar.entrySet()) {
            while(alpha[entry.getKey() - 'a'] > 0) {
                for(char c : dict[entry.getValue()].toCharArray()) alpha[c - 'a']--;
                ans[entry.getValue()]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < ans[i]; j++) sb.append(i);
        return sb.toString();
    }
}
