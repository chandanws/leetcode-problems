// Problem link: https://leetcode.com/problems/distant-barcodes/description/
// Status: Accepted

class PriorityQueueComparator implements Comparator<int[]> {
    @Override
    public int compare(int [] n1, int [] n2) {
        if(n1[1] < n2[1]) return 1;
        else if(n1[1] > n2[1]) return -1;
        return 0;
    }
} 

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Arrays.sort(barcodes);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(5, new PriorityQueueComparator());
        int [] current = new int[]{-1, 0};
        for(int i = 0; i < barcodes.length; i++) {
            if(current[0] == -1) current = new int[]{barcodes[i], 0};
            if(barcodes[i] == current[0]) current[1]++;
            if(i + 1 == barcodes.length || current[0] < barcodes[i + 1]) {
                pq.add(new int[]{current[0], current[1]});
                current[0] = -1;
            }
        }
        current = pq.poll();
        int [] answer = new int[barcodes.length];
        for(int i = 0; pq.size() > 0; i++) {
            answer[i] = current[0];
            current[1]--;
            if(pq.size() > 0) {
                int [] next = pq.poll();
                if(current[1] > 0) pq.add(current);
                current = next;
            }
        }
        answer[barcodes.length - 1] = current[0];
        return answer;
    }
}
