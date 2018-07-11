// Problem link: https://leetcode.com/problems/maximum-swap/description/
// Status: Accepted

class Solution {
    private int [] intToArray(int num) {
        int i = 1, copiedNum = num;
        while((copiedNum /= 10) > 0) i++;
        int [] nums = new int[i];
        for(int j = i - 1; j >= 0; j--) {
            nums[j] = num % 10;
            num /= 10;
        }
        return nums;
    }
    private int arrayToInt(int [] nums) {
        int res = 0, n = nums.length;
        for(int i = 0; i < n; i++) {
            res += nums[i] * Math.pow(10, n - i - 1);
        }
        return res;
    }
    private void swap(int [] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public int maximumSwap(int num) {
        int [] nums = intToArray(num);
        int needChangeIndex = 0;
        while(needChangeIndex < nums.length && nums[needChangeIndex] == 9) needChangeIndex++;
        int maxIndex = nums.length - 1, i = maxIndex - 1, lastCanChange = -1;
        while(needChangeIndex <= i) {
            if(needChangeIndex == i) {
                if(nums[i] < nums[maxIndex]) swap(nums, i, maxIndex);
                else if(lastCanChange != -1) swap(nums, lastCanChange, maxIndex);
            } else if(needChangeIndex != i && nums[maxIndex] < nums[i]) {
                maxIndex = i;
                lastCanChange = i;
            }
            else if(nums[i] < nums[maxIndex]) lastCanChange = i;
            i--;
        }
        return arrayToInt(nums);
    }
}
