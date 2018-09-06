// Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
// Live example link: https://repl.it/repls/GuiltyStickyGeese
// Status: Accepted

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> hm = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode currentNode = dummyHead;
        while(head != null) {
            RandomListNode node = new RandomListNode(head.label);
            hm.put(head, node);
            if(head.random != null) {
                RandomListNode randomNode = hm.containsKey(head.random) ? hm.get(head.random) : new RandomListNode(head.random.label);
                if(!hm.containsKey(head.random)) hm.put(head.random, randomNode);
                node.random = randomNode;
            }
            currentNode.next = node;
            currentNode = currentNode.next;
            head = head.next;
        }
        return dummyHead.next;
    }
}
