// Problem link: https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/description/
// Status: Accepted

class Solution {
    public int getZigzagLabel(int level, int currentPos) {
        if(level % 2 == 0) return currentPos;
        currentPos -= Math.pow(2, level);
        int max = ((int) Math.pow(2, level) * 2) - 1;
        return max - currentPos;
    }
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<Integer>(Arrays.asList(1));
        int [] arr = new int[2];
        for(int i = 0; i < 20; i++) {
            if(Math.pow(2, i) <= label && label < Math.pow(2, i) * 2) {
                if(i % 2 == 0) {
                    arr[0] = (int) Math.pow(2, i);
                    arr[1] = (int) Math.pow(2, i) * 2 - 1;
                } else {
                    arr[0] = (int) Math.pow(2, i) * 2 - 1;
                    arr[1] = (int) Math.pow(2, i);
                }
                break;
            }
        }
        int level = 1, currentPos = 1;
        while(arr[0] != arr[1]) {
            int half = (Math.abs(arr[0] - arr[1]) + 1) / 2;
            if(arr[0] < arr[1]) {
                if(arr[0] <= label && label < (arr[0] + half)) {
                    // left
                    currentPos *= 2;
                    arr[1] -= half;
                } else {
                    // right
                    currentPos = currentPos * 2 + 1;
                    arr[0] += half;
                }
            } else {
                if(arr[0] >= label && label >= (arr[1] + half)) {
                    // left
                    currentPos *= 2;
                    arr[1] += half;
                } else {
                    // right
                    currentPos = currentPos * 2 + 1;
                    arr[0] -= half;
                }
            }
            ans.add(getZigzagLabel(level++, currentPos));
        }
        return ans;
    }
}
