// Problem link: https://leetcode.com/problems/string-compression/description/
// Status: Accepted

class Solution {
    public int compress(char[] chars) {
        int lastInplaceUpdateIndex = 0;
        for(int i = 0; i < chars.length; i++) {
            Character candidate = chars[i];
            int candidateIndex = i;
            while(i + 1 < chars.length && candidate == chars[i + 1]) i++;
            chars[lastInplaceUpdateIndex] = (char) candidate;
            if(i > candidateIndex) {
                for(char c : Integer.toString(i - candidateIndex + 1).toCharArray()) chars[++lastInplaceUpdateIndex] = c;
            }
            lastInplaceUpdateIndex++;
        }
        return lastInplaceUpdateIndex;
    }
}
