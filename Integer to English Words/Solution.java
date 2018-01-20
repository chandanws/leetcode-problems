// Problem link: https://leetcode.com/problems/integer-to-english-words/description/
// Status: Accepted

class Solution {
    public String singleNumberToWord(int num) {
        String [] singleDigits = new String[]{"Zero", "One", "Two", "Three", "Four",
                                          "Five", "Six", "Seven", "Eight", "Nine"};
        String [] tenthDigits = new String[]{"Ten", "Twenty", "Thirty", "Forty", "Fifty",
                                            "Sixty", "Seventy", "Eighty", "Ninety"};
        String [] elevenToNineteenDigits = new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                                              "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String word = "";
        if(num == 0) {
          return "";
        } else if(num >= 11 && num <= 19) {
          word = elevenToNineteenDigits[num-11];
        } else if(num >= 0 && num <= 9) {
          word = singleDigits[num];
        } else if(num % 100 == 0) {
          word = singleDigits[(int)num/100];
          word += " Hundred";
        } else {
          word = tenthDigits[(int)Math.floor((double)num/10)-1];
          if(num % 10 != 0) {
            word += " " + singleDigits[num%10];
          }
        }
        return word;
    }
    public String numberToWords(int num) {
        if(num == 0) { return "Zero"; }
        String stringNum = Integer.toString(num);
        int numSize = (int)Math.ceil((double)stringNum.length()/3);
        String [] digits = new String[numSize];
        for(int i = stringNum.length(), j = 0; i >= 0 && j < numSize; i-=3, j++) {
          if(i-3 >= 0) {
            digits[j] = stringNum.substring(i-3, i);
          } else {
            digits[j] = stringNum.substring(0, i);
          }
        }
        String words = "", remainingWords = "";
        for(int i = 0; i < numSize; i++) {
          if(Integer.valueOf(digits[i]) == 0) {
            continue;
          }
          if(Integer.valueOf(digits[i]) > 100) {
            remainingWords = words;
            words = singleNumberToWord(Integer.valueOf(digits[i])/100*100) + " " +
                    singleNumberToWord(Integer.valueOf(digits[i]) % 100);
            if(Integer.valueOf(digits[i]) % 100 == 0) {
              words = words.trim();
            }
          } else {
            remainingWords = words;
            words = singleNumberToWord(Integer.valueOf(digits[i]));
          }
          switch(i) {
            case 1:
              words += " Thousand";
              break;
            case 2:
              words += " Million";
              break;
            case 3:
              words += " Billion";
              break;
          }
          if(i < numSize) {
            words += " ";
          }
          if(remainingWords.length() != 0) {
            words += remainingWords;
            remainingWords = "";
          }
        }
        return words.trim();
    }
}
