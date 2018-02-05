// Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
// Status: Time Limit Exceeded

class Solution {
    public int reachNumber(int target) {
        int numberOfSteps = 0, currentPos = Math.abs(target);
        if(target != 0) {
          numberOfSteps = (int)Math.floor(Math.sqrt(target*2)) - 1;
        }
        while(currentPos != 0) {
          numberOfSteps++;
          currentPos = Math.abs(target);
          int tryingNumberOfSteps = numberOfSteps;
          while(numberOfSteps > 0) {
            if(Math.abs(currentPos - numberOfSteps) < Math.abs(currentPos + numberOfSteps)) {
              currentPos = currentPos - numberOfSteps;
            } else {
              currentPos = currentPos + numberOfSteps;
            }
            numberOfSteps--;
          }
          numberOfSteps = tryingNumberOfSteps;
        }
        return numberOfSteps;
    }
}
