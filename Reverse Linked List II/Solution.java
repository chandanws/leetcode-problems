// Problem link: https://leetcode.com/problems/reverse-linked-list-ii/description/
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prevNode = null;
        int i = 1;
        while(head != null) {
            if(i == m) {
                ListNode newHead = null;
                ListNode next = null;
                while(head != null && i++ <= n) {
                    next = head.next;
                    head.next = newHead;
                    newHead = head;
                    head = next;
                }
                if(prevNode == null) {
                    ListNode tail = dummyHead.next;
                    dummyHead.next = newHead;
                    tail.next = next;
                } else {
                    ListNode tail = prevNode.next;
                    prevNode.next = newHead;
                    tail.next = next;
                }
            } else {
                prevNode = head;
                head = head.next;
                i++;
            }
        }
        return dummyHead.next;
    }
}
