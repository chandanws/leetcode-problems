// Problem link: https://leetcode.com/problems/binary-search-tree-iterator/description/
// Status: Accepted

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode currentNode;
    private Stack<TreeNode> s;
    
    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        if(root != null) {
            s.push(root);
            currentNode = root;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while(currentNode != null && currentNode.left != null) {
            s.push(currentNode.left);
            currentNode = currentNode.left;
        }
        TreeNode ans = s.pop();
        if(ans.right != null) s.push(ans.right);
        currentNode = ans.right;
        return ans.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
