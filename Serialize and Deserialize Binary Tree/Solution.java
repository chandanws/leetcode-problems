// Problem link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        List<String> bfs = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node != null) { 
                    bfs.add(Integer.toString(node.val));
                    q.offer(node.left);
                    q.offer(node.right);
                } else bfs.add("null");
            }
        }
        return String.join(",", bfs);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        int i = 0, currentIndex = 0, currentLevel = 0;
        List<List<TreeNode>> lists = new ArrayList<>();
        String [] nodes = data.split(",");
        lists.add(new ArrayList<TreeNode>(Arrays.asList(new TreeNode(Integer.parseInt(nodes[i++])))));
        while(i < nodes.length) {
            TreeNode left = null;
            if(!nodes[i].equals("null")) left = new TreeNode(Integer.parseInt(nodes[i]));
            TreeNode right = null;
            if(i + 1 < nodes.length && !nodes[++i].equals("null")) right = new TreeNode(Integer.parseInt(nodes[i]));
            lists.get(currentLevel).get(currentIndex).left = left;
            lists.get(currentLevel).get(currentIndex).right = right;
            if(currentLevel + 1 <= lists.size()) lists.add(new ArrayList<>());
            lists.get(currentLevel + 1).addAll(Arrays.asList(left, right));
            i++;
            do {
                currentIndex++;
                if(currentIndex >= lists.get(currentLevel).size()) {
                    currentIndex = 0;
                    currentLevel++;
                }
            } while(lists.get(currentLevel).get(currentIndex) == null && i + 1 < nodes.length);
        }
        return lists.get(0).get(0);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
