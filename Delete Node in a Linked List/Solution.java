// Problem link: https://leetcode.com/problems/delete-node-in-a-linked-list/description/
// Status: Accepted

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
