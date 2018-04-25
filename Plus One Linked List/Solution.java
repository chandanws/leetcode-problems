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
    // First reverse, and then increment, then reverse back
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
    public ListNode plusOneRevIncrRev(ListNode head) {
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
    // recursively dfs
    private int dfs(ListNode head) {
        if(head == null) return 1;
        int carry = dfs(head.next);
        if(carry == 0) return 0;
        head.val++;
        if(head.val < 10) return 0;
        head.val = 0;
        return 1;
    }
    public ListNode plusOneRecurDfs(ListNode head) {
        if(dfs(head) == 1) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
}
