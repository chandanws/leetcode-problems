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
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        if(l1 != null) currentNode.next = l1;
        else if(l2 != null) currentNode.next = l2;
        return dummyHead.next;
    }
}
