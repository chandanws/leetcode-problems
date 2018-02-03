// Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/description/
// Status: Accepted

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) { return false; }
        ListNode stayHead = head;
        head = head.next;
        while(head != null) {
            if(head == stayHead){ return true; }
            head = head.next;
            stayHead = stayHead.next;
            if(head != null) {
              head = head.next;
            } else {
              return false;
            }
        }
        return false;
    }
}
