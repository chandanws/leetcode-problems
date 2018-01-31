// Problem link: https://leetcode.com/problems/merge-two-sorted-lists/description/
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
          return l1 == null && l2 == null ? null : l1 == null ? l2 : l1;
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode currNode = head, h1 = currNode == l1 ? l1.next : l1, h2 = currNode == l2 ? l2.next : l2;
        while(h1 != null && h2 != null) {
          if(h1.val == h2.val) {
            currNode = currNode.next;
            if(currNode == h1) {
              h1 = h1.next;
              currNode.next = h2;
              h2 = h2.next;
            } else if(currNode == h2) {
              h2 = h2.next;
              currNode.next = h1;
              h1 = h1.next;
            }
          } else if(h1.val > h2.val) {
            currNode.next = h2;
            h2 = h2.next;
          } else if(h1.val < h2. val) {
            currNode.next = h1;
            h1 = h1.next;
          }
          currNode = currNode.next;
        }
        if(h1 == null && h2 != null) {
          currNode.next = h2;
        }
        if(h2 == null && h1 != null) {
          currNode.next = h1;
        }
        return head;
    }
}
