// Problem link: https://leetcode.com/problems/reorder-list/description/
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        Deque<ListNode> dq = new ArrayDeque<ListNode>();
        ListNode temp = head;
        while(temp != null) {
            dq.push(temp);
            temp = temp.next;
        }
        while(!dq.isEmpty() && dq.size() > 1) {
            ListNode next = head.next;
            head.next = dq.pop();
            head.next.next = next;
            head = next;
            dq.pollLast();
        }
        head.next = null;
    }
}
