// Problem link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
// Status: Accepted

import java.util.Comparator;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        HashSet<String> hs = new HashSet<String>();
        PriorityQueue<SpecialNode> heap = new PriorityQueue<SpecialNode>(k, specialNodeComparator);
        int n = matrix.length;
        SpecialNode largestNode = new SpecialNode(n - 1,  n - 1, matrix[n - 1][n - 1]);
        hs.add((n - 1) + "," + (n - 1));
        heap.add(largestNode);
        k = n * n - k;
        while(k > 0) {
            SpecialNode node = heap.poll();
            if(node.i - 1 >= 0 && !hs.contains((node.i - 1) + "," + node.j)) {
                hs.add((node.i - 1) + "," + node.j);
                heap.add(new SpecialNode(node.i - 1, node.j, matrix[node.i - 1][node.j]));
            }
            if(node.j - 1 >= 0 && !hs.contains(node.i + "," + (node.j - 1))) {
                hs.add(node.i + "," + (node.j - 1));
                heap.add(new SpecialNode(node.i, node.j - 1, matrix[node.i][node.j - 1]));
            }
            k--;
        }
        return heap.poll().value;
    }
    public static Comparator<SpecialNode> specialNodeComparator = new Comparator<SpecialNode>(){
	@Override
	public int compare(SpecialNode n1, SpecialNode n2) {
            return n2.value - n1.value;
        }
    };
}

class SpecialNode {
    int i;
    int j;
    int value;
    SpecialNode(int x, int y, int val) {
        i = x;
        j = y;
        value = val;
    }
}
