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
        ListNode newHead = null;
        ListNode tail = null;
        while(head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            ListNode next = head.next.next;
            second.next = first;
            first.next = next;
            if(newHead == null) newHead = second;
            if(tail == null) tail = first;
            else {
                tail.next = second;
                tail = first;
            }
            head = next;
        }
        return newHead;
    }
}
