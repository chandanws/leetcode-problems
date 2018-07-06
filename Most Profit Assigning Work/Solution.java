// Problem link: https://leetcode.com/problems/most-profit-assigning-work/description/
// Status: Accepted

class Solution {
    private int binarySearch(int [] difficulty, int target) {
        int low = 0, high = difficulty.length - 1;
        while(low < high) {
            int mid = low + ((high - low) / 2);
            if(difficulty[mid] == target) return mid;
            if(difficulty[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for(int i = 0; i < difficulty.length; i++) {
            if(!tm.containsKey(difficulty[i]) || (tm.containsKey(difficulty[i]) &&
                profit[i] > tm.get(difficulty[i]))) tm.put(difficulty[i], profit[i]);
        }
        int lastProfit = -1;
        for(Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            if(lastProfit == -1) lastProfit = entry.getValue();
            else if(entry.getValue() < lastProfit) tm.put(entry.getKey(), lastProfit);
            else if(entry.getValue() > lastProfit) lastProfit = entry.getValue();
        }
        int j = 0;
        int [] sortedDifficulty = new int[tm.size()];
        int [] sortedProfit = new int[tm.size()];
        for(Map.Entry<Integer, Integer> entry : tm.entrySet()) {
            sortedDifficulty[j] = entry.getKey();
            sortedProfit[j] = entry.getValue();
            j++;
        }
        int sum = 0;
        for(int i = 0; i < worker.length; i++) {
            int index = binarySearch(sortedDifficulty, worker[i]);
            if(sortedDifficulty[index] <= worker[i]) sum += sortedProfit[index];
            else if(index - 1 >= 0) sum += sortedProfit[index - 1];
        }
        return sum;
    }
}
