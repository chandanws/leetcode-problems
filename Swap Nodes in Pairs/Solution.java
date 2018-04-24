// Problem link: https://leetcode.com/problems/swap-nodes-in-pairs/description/
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode copiedHead = head.next;
        ListNode fast = head.next.next;
        ListNode slow = head;
        ListNode copiedTail = null;
        while(fast != null || (slow != null && slow.next != null)) {
            slow.next.next = slow;
            slow = slow.next;
            slow.next.next = fast;
            if(copiedTail != null) copiedTail.next = slow;
            copiedTail = slow.next;
            slow = fast;
            if(fast != null) {
                if(fast.next != null) {
                    fast = fast.next.next;
                } else { 
                    fast = fast.next;
                }
            }
        }
        return copiedHead;
    }
}
