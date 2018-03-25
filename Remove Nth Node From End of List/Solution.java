// Problem link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        if(head.next.next == null) {
            if(n == 1) head.next = null;
            else if(n == 2) head = head.next;
            return head;
        }
        ListNode prevNode = null;
        ListNode copiedHead = head;
        ListNode currentNode = head;
        int i = 1;
        while(currentNode.next != null) {
            if(i >= n) {
                prevNode = head;
                head = head.next;
            }
            currentNode = currentNode.next;
            i++;
        }
        if(n == i) copiedHead = copiedHead.next;
        else if(n == 1) prevNode.next = null;
        else prevNode.next = head.next;
        return copiedHead;
    }
}
