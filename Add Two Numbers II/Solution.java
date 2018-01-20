// Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
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
    public static ListNode reverseListNode(ListNode head) {
        ListNode newH = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newH;
            newH = head;
            head = next;
        }
        return newH;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverseListNode(l1);
        ListNode rl2 = reverseListNode(l2);
        ListNode newH = null;
        int remaining = 0;
        while(rl1 != null || rl2 != null || remaining != 0) {
          int l1D = 0, l2D = 0;
          if(rl1 != null) {
            l1D = rl1.val;
            rl1 = rl1.next;
          }
          if(rl2 != null) {
            l2D = rl2.val;
            rl2 = rl2.next;
          }
          int sum = l1D + l2D + remaining;
          remaining = 0;
          if(sum > 9) {
            remaining = 1;
          }
          ListNode newNode = new ListNode(sum%10);
          newNode.next = newH;
          newH = newNode;
        }
        return newH;
    }
}
