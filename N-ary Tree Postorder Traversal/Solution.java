// Problem link: https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
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
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<Node> s = new Stack<Node>();
        s.push(root);
        while(!s.isEmpty()) {
            Node currentNode = s.pop();
            res.add(currentNode.val);
            int size = currentNode.children.size();
            for(int i = 0; i < size; i++) s.push(currentNode.children.get(i));
        }
        Collections.reverse(res);
        return res;
    }
}
