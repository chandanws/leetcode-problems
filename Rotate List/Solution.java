// Problem link: https://leetcode.com/problems/rotate-list/description/
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
    private ListNode rotateRightOnce(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newTail = head, oldTail = head.next, newHead = head;
        while(oldTail.next != null) {
            newTail = oldTail;
            oldTail = oldTail.next;
        }
        newTail.next = null;
        oldTail.next = newHead;
        newHead = oldTail;
        return newHead;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode h = head;
        while(h != null) {
            count++;
            h = h.next;
        }
        if(count > 0) k %= count;
        for(int i = 0; i < k; i++) head = rotateRightOnce(head);
        return head;
    }
}
