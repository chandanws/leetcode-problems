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
        ListNode tail = head;
        ListNode newHead = null;
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
        ListNode tail = dummyHead;
        tail.next = head;
        while(head != null) {
            ListNode start = head;
            for(int i = 0; i < k - 1 && head != null; i++) head = head.next;
            if(head != null) {
                ListNode next = head.next;
                head.next = null;
                ListNode [] nodes = reverse(start);
                tail.next = nodes[0];
                tail = nodes[1];
                nodes[1].next = next;
                head = next;
            }
        }
        return dummyHead.next;
    }
}
