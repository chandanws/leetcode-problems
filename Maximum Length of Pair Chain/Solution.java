// Problem link: https://leetcode.com/problems/maximum-length-of-pair-chain/description/
// Status: Accepted

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        int max = 1, j = 0;
        int [] lastPair = new int[]{pairs[0][0], pairs[0][1]};
        while(j < pairs.length) {
            int [] lastCurrentPair = pairs[j];
            while(j + 1 < pairs.length && lastCurrentPair[0] == pairs[j + 1][0]) j++;
            if(lastPair[1] < lastCurrentPair[0]) {
                max++;
                lastPair = lastCurrentPair;
            } else if(lastPair[1] > lastCurrentPair[1]) lastPair = lastCurrentPair;
            j++;
        }
        return max;
    }
}
