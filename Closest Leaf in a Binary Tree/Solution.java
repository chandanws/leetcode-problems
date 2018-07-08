// Problem link: https://leetcode.com/problems/closest-leaf-in-a-binary-tree/description/
// Status: Accepted

import java.awt.Point;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private ArrayList<Point> helper(TreeNode root, int target, int level) {
        if(root.left == null && root.right == null) {
            if(root.val == target) return new ArrayList<>(Arrays.asList(new Point(level, root.val), new Point(level, root.val)));
            else return new ArrayList<>(Arrays.asList(new Point(-1, -1), new Point(level, root.val)));
        }
        ArrayList<Point> l1 = new ArrayList<Point>(), l2 = new ArrayList<Point>();
        if(root.left != null) l1 = helper(root.left, target, level + 1);
        if(root.right != null) l2 = helper(root.right, target, level + 1);
        ArrayList<Point> listToReturn = l1;
        Point targetNode = null;
        if(l1.size() > 0 && l2.size() > 0) {
            if(l1.get(0).getX() == -1 && l2.get(0).getX() == -1) {
                if(l1.get(1).getX() > l2.get(1).getX()) listToReturn = l2;
            } else {
                int minDist1 = 0, minDist2 = 0;
                if(l1.get(0).getX() > -1) targetNode = l1.get(0);
                else targetNode = l2.get(0);
                if(l1.get(0).getX() > -1) {
                    minDist1 = Math.abs((int) targetNode.getX() - (int) l1.get(1).getX());
                    minDist2 = Math.abs((int) targetNode.getX() + (int) l2.get(1).getX() - level * 2);
                    if(minDist1 > minDist2) listToReturn = l2;
                } else {
                    minDist1 = Math.abs((int) targetNode.getX() + (int) l1.get(1).getX() - level * 2);
                    minDist2 = Math.abs((int) targetNode.getX() - (int) l2.get(1).getX());
                    if(minDist1 > minDist2) listToReturn = l2;
                }
            }
        } else if(l1.size() == 0) listToReturn = l2;
        if(root.val == target) listToReturn.set(0, new Point(level, root.val));
        else if(targetNode != null) listToReturn.set(0, targetNode);
        return listToReturn;
    }
    public int findClosestLeaf(TreeNode root, int k) {
        if(root.left == null && root.right == null) return root.val;
        return (int) helper(root, k, 0).get(1).getY();
    }
}
