// Problem link: https://leetcode.com/problems/reverse-nodes-in-k-group/description/
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
    private ListNode [] reverse(ListNode head) {
        ListNode newHead = null;
        ListNode tail = head;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return new ListNode[]{newHead, tail};
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tail = dummyHead;
        while(head != null) {
            ListNode currentHead = head;
            for(int i = 1; i < k && head != null; i++) head = head.next;
            if(head == null) break;
            ListNode next = head.next;
            head.next = null;
            ListNode [] nodes = reverse(currentHead);
            tail.next = nodes[0];
            nodes[1].next = next;
            tail = nodes[1];
            head = next;
        }
        return dummyHead.next;
    }
}
