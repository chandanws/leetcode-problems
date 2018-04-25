// Problem link: https://leetcode.com/problems/plus-one-linked-list/description/
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
    private ListNode reverseList(ListNode head) {
        ListNode currentNode = head;
        ListNode copiedHead = null;
        while(currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = copiedHead;
            copiedHead = currentNode;
            currentNode = next;
        }
        return copiedHead;
    }
    public ListNode plusOne(ListNode head) {
        ListNode reverseHead = reverseList(head);
        ListNode currentNode = reverseHead;
        currentNode.val++;
        while(currentNode != null) {
            if(currentNode.val < 10) break;
            currentNode.val = 0;
            if(currentNode.next == null) currentNode.next = new ListNode(0);
            currentNode.next.val++;
            currentNode = currentNode.next;
        }
        return reverseList(reverseHead);
    }
}
