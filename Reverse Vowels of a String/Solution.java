// Problem link: https://leetcode.com/problems/reverse-vowels-of-a-string/description/
// Status: Accepted

class Solution {
    private boolean isVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public String reverseVowels(String s) {
        int len = s.length(), i = 0, j = len - 1;
        char [] charArray = s.toCharArray();
        while(i < j) {
            while(!(isVowels(Character.toLowerCase(charArray[i]))) && i < j) i++;
            while(!(isVowels(Character.toLowerCase(charArray[j]))) && i < j) j--;
            if(i == j) break;
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            if(i + 1 == j) break;
            i++;
            j--;
        }
        return String.valueOf(charArray);
    }
}
