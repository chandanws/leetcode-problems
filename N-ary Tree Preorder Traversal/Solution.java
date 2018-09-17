// Problem link: https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
// Status: Accepted

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while(!s.isEmpty()) {
            Node node = s.pop();
            res.add(node.val);
            int size = node.children.size();
            for(int i = size - 1; i >= 0; i--) s.push(node.children.get(i));
        }
        return res;
    }
}
