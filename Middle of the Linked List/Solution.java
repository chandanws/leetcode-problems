// Problem link: https://leetcode.com/problems/middle-of-the-linked-list/description/
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
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        else if(head.next == null) return head;
        else if(head.next.next == null) return head.next;
        ListNode slow = head, fast = head.next;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast = fast.next;
        }
        return slow;
    }
}
