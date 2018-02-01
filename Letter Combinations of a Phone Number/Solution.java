// Problem link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
// Status: Accepted

class Solution {
    public List<Character[]> getT9() {
        List<Character[]> t9 = new ArrayList<Character[]>();
        t9.add(0, new Character[]{});
        t9.add(1, new Character[]{});
        t9.add(2, new Character[]{'a', 'b', 'c'});
        t9.add(3, new Character[]{'d', 'e', 'f'});
        t9.add(4, new Character[]{'g', 'h', 'i'});
        t9.add(5, new Character[]{'j', 'k', 'l'});
        t9.add(6, new Character[]{'m', 'n', 'o'});
        t9.add(7, new Character[]{'p', 'q', 'r', 's'});
        t9.add(8, new Character[]{'t', 'u', 'v'});
        t9.add(9, new Character[]{'w', 'x', 'y', 'z'});
        return t9;
    }
    public List<String> letterCombinations(String digits) {
        List<Character[]> t9 = getT9();
        Stack<String> s1 = new Stack<String>();
        Stack<String> s2 = new Stack<String>();
        if(digits.length() > 0) {
          s2.push("");
        }
        char [] digitsArr = digits.toCharArray();
        for(int i = 0; i < digitsArr.length; i++) {
          Stack<String> pushS = i % 2 == 0 ? s1 : s2;
          Stack<String> popS = i % 2 == 0 ? s2 : s1;
          while(!popS.empty()) {
            String str = popS.pop();
            for(int j = 0; j < t9.get(Character.getNumericValue(digitsArr[i])).length; j++) {
              pushS.push(str + t9.get(Character.getNumericValue(digitsArr[i]))[j]);
            }
          }
        }
        Stack<String> popS = digits.length() % 2 == 0 ? s2 : s1;
        List<String> listOfCombinations = new ArrayList<String>();
        while(!popS.empty()) {
          listOfCombinations.add(popS.pop());
        }
        return listOfCombinations;
    }
}
