// Problem link: https://leetcode.com/problems/roman-to-integer/description
// Live example link: Pending
// Status: Time Limit Exceeded

class Solution {
    public static boolean possibleMatch(int currentNum, int prevNum) {
        // DC, LX, VI is a match while others aren't.
        // 600, 60, 6 in numbers
        boolean isMatched = false;

        switch (currentNum + prevNum) {
            case 600:
            case 60:
            case 6:
                isMatched = true;
                break;
            default:
                isMatched = false;
        }

        return isMatched;
    }
    
    public int romanToInt(String romanNumber) {
        Map<String, Integer> romanNumbersChart = new HashMap<String, Integer>();
        romanNumbersChart.put("I", 1);
        romanNumbersChart.put("V", 5);
        romanNumbersChart.put("X", 10);
        romanNumbersChart.put("L", 50);
        romanNumbersChart.put("C", 100);
        romanNumbersChart.put("D", 500);
        romanNumbersChart.put("M", 1000);
        int sum = 0, rowSum = 0, currentNum = 0;
        String [] splittedRomanNumber = romanNumber.split("");
        int prevNum = romanNumbersChart.get(splittedRomanNumber[0]);

        for (String singleCharacter: splittedRomanNumber) {
          currentNum = romanNumbersChart.get(singleCharacter);
          if (currentNum < prevNum) {
            if (possibleMatch(currentNum, prevNum)) {
              // to match things like DC, LX, VI
              rowSum += currentNum;
            } else {
              // sum will be added only when 1000th or 100th or 10th is finished counting
              // for things like CDL
              sum += rowSum;
              rowSum = currentNum;
            }
          } else if (currentNum > prevNum) {
            // special case when you need minus like CD
            rowSum = currentNum - prevNum;
          } else if (currentNum == prevNum) {
            // for things like VII
            rowSum += currentNum;
          }
          // add the last 10th back to sum
          prevNum = currentNum;
        }
        sum += rowSum;

        return sum;
    }
}
