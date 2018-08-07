// Problem link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
// Status: Accepted

class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1.length == 0 || nums2.length == 0) return res;
        Queue<SpecialNode> pq = new PriorityQueue<SpecialNode>(Math.max(nums1.length, nums2.length), SpecialNodeComparator);
        for(int i = 0; i < nums2.length; i++) pq.add(new SpecialNode(0, i, nums1[0] + nums2[i]));
        for(int i = 0; i < k && !pq.isEmpty(); i++) {
            SpecialNode nextSpecialNode = pq.poll();
            res.add(new int[]{nums1[nextSpecialNode.x], nums2[nextSpecialNode.y]});
            if(nextSpecialNode.x + 1 < nums1.length)
                pq.offer(new SpecialNode(nextSpecialNode.x + 1, nextSpecialNode.y, nums1[nextSpecialNode.x + 1] + nums2[nextSpecialNode.y]));
        }
        return res;
    }
    public static Comparator<SpecialNode> SpecialNodeComparator = new Comparator<SpecialNode>(){
        @Override
        public int compare(SpecialNode n1, SpecialNode n2) {
            return n1.sum - n2.sum;
        }
    };
}

class SpecialNode {
    public int sum;
    public int x;
    public int y;
    public SpecialNode(int _x, int _y, int _sum) {
        x = _x;
        y = _y;
        sum = _sum;
    }
}
