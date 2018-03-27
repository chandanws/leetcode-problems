// Problem link: https://leetcode.com/problems/remove-linked-list-elements/description/
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode currentNode = new ListNode(0);
        ListNode dummyHead = currentNode;
        currentNode.next = head;
        while(currentNode.next != null) {
            if(currentNode.next.val == val) currentNode.next = currentNode.next.next;
            else currentNode = currentNode.next;
        }
        return dummyHead.next;
    }
}
