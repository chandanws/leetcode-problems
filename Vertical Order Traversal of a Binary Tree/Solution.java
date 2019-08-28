// Problem link: https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
// Status: Accepted

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CustomTreeNode {
    TreeNode node;
    int x, y;
    CustomTreeNode(TreeNode root, int pt1, int pt2) {
        node = root;
        x = pt1;
        y = pt2;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, LinkedHashMap<Integer, List<Integer>>> hm = new HashMap<Integer, LinkedHashMap<Integer, List<Integer>>>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        LinkedList<CustomTreeNode> q = new LinkedList<CustomTreeNode>();
        q.offer(new CustomTreeNode(root, 0, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                CustomTreeNode current = q.poll();
                min = Math.min(current.x, min);
                max = Math.max(current.x, max);
                if(!hm.containsKey(current.x)) hm.put(current.x, new LinkedHashMap<Integer, List<Integer>>());
                if(!hm.get(current.x).containsKey(current.y)) hm.get(current.x).put(current.y, new ArrayList<>());
                List<Integer> l = hm.get(current.x).get(current.y);
                int index = Collections.binarySearch(l, current.node.val);
                if(index < 0) l.add((index*-1) - 1, current.node.val);
                else l.add(index, current.node.val);
                if(current.node.left != null) q.offer(new CustomTreeNode(current.node.left, current.x - 1, current.y - 1));
                if(current.node.right != null) q.offer(new CustomTreeNode(current.node.right, current.x + 1, current.y - 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = min; i <= max; i++) {
            if(hm.containsKey(i)) {
                List<Integer> tempList = new ArrayList<>();
                LinkedHashMap<Integer, List<Integer>> lHm = hm.get(i);
                for(Map.Entry<Integer, List<Integer>> entry : lHm.entrySet()) {
                    for(int j = 0; j < entry.getValue().size(); j++) tempList.add(entry.getValue().get(j));
                }
                ans.add(tempList);
            }
        }
        return ans;
    }
}
