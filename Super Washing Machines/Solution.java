// Problem link: https://leetcode.com/problems/super-washing-machines/description/
// Status: Accepted

class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for(int num : machines) sum += num;
        int target = sum / machines.length, max = 0;
        int [] movesNeeded = new int[machines.length];
        for(int i = 0; i < machines.length - 1; i++) {
            if(machines[i] > target) max = Math.max(max, Math.abs(machines[i] - target));
            movesNeeded[(i + 1) % machines.length] = movesNeeded[i] += machines[i] - target;
            max = Math.max(max, Math.abs(movesNeeded[i]));
        }
        max = Math.max(max, Math.abs(movesNeeded[machines.length - 1]));
        return machines[machines.length - 1] + movesNeeded[machines.length - 1] == target ? max : -1;
    }
}
